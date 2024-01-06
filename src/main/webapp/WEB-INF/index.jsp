<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login and Registration page</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<h1>Welcome</h1>
	<form:form action="/register" method="post" modelAttribute="newUser">
	
	<h2>Register</h2>
		<table>
			<thead>
				<tr>
					<td class="float-left">Username:</td>
					<td class="float-left"><form:errors path="userName"
							class="text-danger" /> <form:input class="input" path="userName" />
					</td>
				</tr>
				<tr>
					<td class="float-left">Email:</td>
					<td class="float-left"><form:errors path="email"
							class="text-danger" /> <form:input class="input" path="email" />
					</td>
				</tr>
				<tr>
					<td class="float-left">Password:</td>
					<td class="float-left"><form:errors path="password"
							class="text-danger" /> <form:input class="input" path="password" />
					</td>
				</tr>
				<tr>
					<td class="float-left">Confirm PW:</td>
					<td class="float-left"><form:errors path="confirm"
							class="text-danger" /> <form:input class="input" path="confirm" />
					</td>
				</tr>
				<tr>
					<td colspan=2><input class="input" type="submit"
						value="Register" /></td>
				</tr>
			</thead>
		</table>
	</form:form>
	<hr>
	<form:form action="/login" method="post" modelAttribute="newLogin">
	<h2>Login</h2>
		<table>
			<thead>
				<tr>
					<td class="float-left">Email:</td>
					<td class="float-left"><form:errors path="email"
							class="text-danger" /> <form:input class="input" path="email" />
					</td>
				</tr>
				<tr>
					<td class="float-left">Password:</td>
					<td class="float-left"><form:errors path="password"
							class="text-danger" /> <form:input class="input" path="password" />
					</td>
				</tr>
				<tr>
					<td colspan="2"><input class="input" type="submit"
						value="Login" /></td>
				</tr>
			</thead>
		</table>
	</form:form>
</body>
</html>