package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Contact;

public class ContactDao {
	
	private Connection con;

	public ContactDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean saveContact(Contact c) {
		
		boolean b=false;
		try {
			
			String query="insert into contact(name,email,phno,about,userid)values(?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			
			pst.setString(1,c.getName());
			pst.setString(2,c.getEmail());
			pst.setString(3,c.getPhno());
			pst.setString(4,c.getAbout());
			pst.setInt(5,c.getUserId());
			
			int i=pst.executeUpdate();
			if (i==1) {
				
				b=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		return b;
	}
	
	
	public List<Contact> getAllContacts(int uId){
		
		List<Contact> list=new ArrayList<Contact>();
		Contact c=null;
		
		try {
			String query="select * from contact where userid=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1, uId);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				c=new Contact();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhno(rs.getString(4));
				c.setAbout(rs.getString(5));
				list.add(c);
				
			}
			
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		return list;
	}
	public Contact getContactById(int cid) {
		Contact c=new Contact();
		try {
			PreparedStatement pst=con.prepareStatement("select * from contact where id=?");
			pst.setInt(1, cid);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhno(rs.getString(4));
				c.setAbout(rs.getString(5));
			}
			
			
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		
		
		
		
		
		return c;
	}
	
	public boolean updateContact(Contact c) {
		boolean b=false;
        try {
			
			String query="update contact set name=?,email=?,phno=?,about=? where id=?";
			PreparedStatement pst=con.prepareStatement(query);
			
			pst.setString(1,c.getName());
			pst.setString(2,c.getEmail());
			pst.setString(3,c.getPhno());
			pst.setString(4,c.getAbout());
			pst.setInt(5,c.getId());
			
			int i=pst.executeUpdate();
			if (i==1) {
				
				b=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return b;
	}
	
	public boolean deleteContactById(int id) {
		boolean b=false;
		try {
			String query="delete from contact where id=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if (i==1) {
				
				 b=true;
				
			}  
			} catch (Exception e) {
			 e.printStackTrace();
		    }
		
		
		
		return b;
	}
	
	
}




