<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddContact Page</title>
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
<h3 class="text-center text-success"><i class="fas fa-plus-circle"></i>Add contact Page</h3>
<% String successMsg=(String)session.getAttribute("successMsg");
String failureMsg=(String)session.getAttribute("failureMsg");

if(successMsg!=null){ %>

<p class="text-success text-center"><%=successMsg %></p>
	
<% session.removeAttribute("successMsg");
}
  if(failureMsg!=null){%>
  
  <p class="text-danger text-center"><%=failureMsg %></p>
	  
 <% session.removeAttribute("failureMsg");
 
  }


%>
 
<form action="addContact" method="post">
    <%
    if(user!=null){%>
    
    <input type="hidden" value="<%=user.getId()%>" name="userid" >
    	
  <% }
    
    %>
  <div class="form-group">
    <label for="exampleInputEmail1">Enter Name</label>
    <input name="name" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter name">
     
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
     
  </div>
   <div class="form-group">
    <label for="exampleInputEmail1">Enter phone Number</label>
    <input name="phno" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Phone number">
     
  </div>
  <div class="form-group">
    <textarea rows="3" cols="" placeholder="Enter about" class="form-control" name="about"></textarea>
     
  </div>
   
   
   <div class="text-center">
   <button type="submit" class="btn btn-primary">Add</button>
   </div>
</form>

</div>
</div>
</div>
</div>
</div>
 <div style="margin-top:120px">
<%@include file="component/footer.jsp" %>
</div>
 

</body>



</html>