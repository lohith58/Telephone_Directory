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
import com.entity.Contact;


@WebServlet("/update")
public class EditServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		int cid=Integer.parseInt(req.getParameter("cid"));
		 
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phno=req.getParameter("phno");
		String about=req.getParameter("about");
        Contact c=new Contact();
        c.setId(cid);
        c.setName(name);
        c.setEmail(email);
        c.setPhno(phno);
        c.setAbout(about);
		
		ContactDao dao=new ContactDao(DbConnect.getConnection());
		boolean b=dao.updateContact(c);
		HttpSession session=req.getSession();
		
		if (b) {
			session.setAttribute("successMsg","Your Contact Updated Successfully");
			resp.sendRedirect("viewContact.jsp");
		} else {
			session.setAttribute("failureMsg","SomethingWent Wrong Pls Try Again");
			resp.sendRedirect("editContact.jsp?cid="+cid);

		}
		
		
		
	}
	
	

}
