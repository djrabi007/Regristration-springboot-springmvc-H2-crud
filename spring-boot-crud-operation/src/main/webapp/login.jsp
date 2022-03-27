<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Login Form</title>
</head>
<body>
	<ul class="nav navbar-nav">
		<li><a href="/">Registration</a></li>
	</ul>
	
	<form:form name="submitForm" method="POST" action="/login-user1">

		<div align="center">
			<table>
				<tr>
					<td>Username(Email Id)</td>
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
	
	
	
</body>
</html>