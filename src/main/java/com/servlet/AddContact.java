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

@WebServlet("/addContact")
public class AddContact extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		int userId=Integer.parseInt(req.getParameter("userid"));
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phno=req.getParameter("phno");
		String about=req.getParameter("about");
		 
		
		Contact c=new Contact(name,email,phno,about,userId);
		
		ContactDao dao=new ContactDao(DbConnect.getConnection());
		HttpSession session=req.getSession();
		boolean b=dao.saveContact(c);
		
		if (b) {
			session.setAttribute("successMsg","Your Contact Saved Successfully");
			resp.sendRedirect("addContact.jsp");
		} else {
			session.setAttribute("failureMsg","SomethingWent Wrong Pls Try Again");
			resp.sendRedirect("addContact.jsp");

		}
		
		
		
	}
	
}

