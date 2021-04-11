package com.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.DbConnect;
import com.dao.UserDao;
import com.entity.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException{
		
		 
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		 
		User user=new User(name,email,password);
		
		UserDao dao=new UserDao(DbConnect.getConnection());
		
		boolean f=dao.userRegistration(user);
		
		HttpSession session=req.getSession();
		
		if(f) {
			
			session.setAttribute("successMsg","User Registration Success! You can login");
			res.sendRedirect("register.jsp");
			
		}else {
			session.setAttribute("errorMsg","User Registration Failure...Try Again!!!!!!!!!!");
			res.sendRedirect("register.jsp");
		}
		
	}
	

}
