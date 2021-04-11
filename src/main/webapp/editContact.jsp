<%@page import="com.entity.Contact"%>
<%@page import="com.connection.DbConnect"%>
<%@page import="com.dao.ContactDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EditContact Page</title>
<%@include file="component/allCss.jsp"%>
</head>
<body>
<%@include file="component/navbar.jsp" %>
<%   
  if(user==null){
	  session.setAttribute("invalidMsg","Please Login First To Access Others...");
      response.sendRedirect("login.jsp");
   }
%>
<div class="container-fluid">
<div class="row p-3">
<div class="com-md-6 offset-md-3">
<div class="card">
<div class="card-body">
<h3 class="text-center text-success"><i class="fas fa-user-edit"></i>Edit contact Page</h3>
<%  
String failureMsg=(String)session.getAttribute("failureMsg");

 
  if(failureMsg!=null){%>
  
  <p class="text-danger text-center"><%=failureMsg %></p>
	  
 <% session.removeAttribute("failureMsg");
 
  }


%>
 
<form action="update" method="post">
    <%
     int cid=Integer.parseInt(request.getParameter("cid"));
    ContactDao dao=new ContactDao(DbConnect.getConnection());
    Contact c=dao.getContactById(cid);
    %>
   <input type="hidden" value="<%=cid%>" name="cid">
  <div class="form-group">
    <label for="exampleInputEmail1">Enter Name</label>
    <input value="<%=c.getName() %>" name="name" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
     
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input value="<%=c.getEmail() %>" name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
     
  </div>
   <div class="form-group">
    <label for="exampleInputEmail1">Enter phone Number</label>
    <input value="<%=c.getPhno() %>" name="phno" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
     
  </div>
  <div class="form-group">
    <textarea   rows="3" cols="" placeholder="Enter about" class="form-control" name="about"><%=c.getAbout() %></textarea>
     
  </div>
   
   
   <div class="text-center">
   <button type="submit" class="btn btn-primary">Update</button>
   </div>
</form>

</div>
</div>
</div>
</div>
</div>
 <div style="margin-top: 130px">
<%@include file="component/footer.jsp" %>
</div>
 

</body>
</html>