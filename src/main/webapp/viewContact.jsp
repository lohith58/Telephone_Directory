<%@page import="com.entity.Contact"%>
<%@page import="java.util.List"%>
<%@page import="com.connection.DbConnect"%>
<%@page import="com.dao.ContactDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ViewContact Page</title>
<%@include file="component/allCss.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #c9c9c7;
}
</style>

</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<%
	if (user == null) {
		session.setAttribute("invalidMsg", "Please Login First To Access Others...");
		response.sendRedirect("login.jsp");
	}
	%>
	<%
	String successMsg = (String) session.getAttribute("successMsg");
	if (successMsg != null) {
	%>

	<div class="alert alert-success" role="alert"><%=successMsg%></div>

	<%
	session.removeAttribute("successMsg");
	}
	%>

	<%
	String failureMsg = (String) session.getAttribute("failureMsg");
	if (failureMsg != null) {
	%>
	<div class="alert alert-success" role="alert"><%=successMsg%></div>
	<%
	session.removeAttribute("successMsg");

	}
	%>

	<div class="container">
		<div class="row p-4">


			<%
			if (user != null) {

				ContactDao dao = new ContactDao(DbConnect.getConnection());
				List<Contact> contact = dao.getAllContacts(user.getId());

				for (Contact c : contact) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body">
						<h5>
							Name:
							<%=c.getName()%></h5>
						<p>
							Email:
							<%=c.getEmail()%></p>
						<P>
							PhNo :
							<%=c.getPhno()%></P>
						<p>
							About:
							<%=c.getAbout()%></p>
						<div class="text-center">
							<div class="container">
								<a href="editContact.jsp?cid=<%=c.getId()%>"
									class="btn btn-success btn-sm text-white">Edit</a>
								<div style="margin-top: 10px">
									<form action="delete?cid=<%=c.getId()%>" method="post">
										<button type="submit"
											class="btn btn-danger btn-sm text-white ">Delete</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>



			<%
			}

			}
			%>
		</div>
	</div>
</body>
</html>