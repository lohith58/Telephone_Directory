package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.DbConnect;
import com.dao.ContactDao;


@WebServlet("/delete")
public class DeleteContact extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		int cid=Integer.parseInt(req.getParameter("cid"));
		
		ContactDao dao=new ContactDao(DbConnect.getConnection());
		
		boolean b=dao.deleteContactById(cid);
		HttpSession session=req.getSession();
		if (b) {
			session.setAttribute("successMsg","Contact Deleted Successfully");
			resp.sendRedirect("viewContact.jsp"); 
		} else {
			session.setAttribute("failureMsg","Please Try Again");
			resp.sendRedirect("viewContact.jsp"); 

			
		}
	
	}
}
