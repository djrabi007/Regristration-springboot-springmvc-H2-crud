<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Login Form</title>
</head>
<body>
	<ul class="nav navbar-nav">
		<li><a href="/login1">Login</a></li>
		<li><a href="/show-users1">All Users</a></li>
	</ul>


	<form:form name="submitForm" method="POST" action="save-user1">
		<div align="center">
			<table>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstname" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastname" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" /></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><input type="text" name="phonenumber" /></td>
				</tr>
				<tr>
					<td>Role Id</td>
					<td><input type="text" name="roleid" /></td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td><input type="text" name="emailid" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="Password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
			<div style="color: red">${error}</div>

		</div>
	</form:form>
	
	
	<!--  All User  -->

	<div class="container text-center" id="tasksDiv">

		<h3>All Users</h3>

		<hr>

		<div class="table-responsive">

			<table class="rtable">

				<thead>

					<tr style="border-bottom: 1pt solid black;">

						<th>Id</th>

						<th>First Name</th>

						<th>LastName</th>

						<th>Address</th>

						<th>Phone</th>

						<th>Email Id</th>

					</tr>

				</thead>

				<tbody>

					<c:forEach var="newuser" items="${newusers }">

						<tr style="border-bottom: 1pt solid black;">

							<td>${newuser.loginid}</td>

							<td>${newuser.firstname}</td>

							<td>${newuser.lastname}</td>

							<td>${newuser.address}</td>

							<td>${newuser.phonenumber}</td>

							<td>${newuser.emailid}</td>

						</tr>

					</c:forEach>

				</tbody>

			</table>

		</div>

	</div>



</body>
</html>