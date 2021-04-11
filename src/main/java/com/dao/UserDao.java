package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDao {
	
	private Connection con;

	public UserDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean userRegistration(User u) {
		
		boolean b=false;
		try {
			
			String query="insert into user(name,email,password)values(?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,u.getName());
			pst.setString(2,u.getEmail());
			pst.setString(3,u.getPassword());
			
			int i=pst.executeUpdate();
			
			if(i==1) {
				b=true;
			}
			
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
		
		
		
		
		return b;
		
	}
	
   public User loginUser(String email,String password) {
	   
	   User user=null;
	   try {
		  
		   String query="select * from user where email=? and password=?";
		   PreparedStatement pst=con.prepareStatement(query);
		   pst.setString(1,email);
		   pst.setString(2,password);
		   
		   ResultSet rs=pst.executeQuery();
		   while(rs.next()) {
			   
			   user=new User();
			   user.setId(rs.getInt(1));
			   user.setName(rs.getString(2));
			   user.setEmail(rs.getString(3));
			   user.setPassword(rs.getString(4));
			   
			   
		   }
		   
		   
		   
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   return user;
	   
   }
	
	

}
