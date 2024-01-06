<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show book</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
<link rel="stylesheet" href="/css/main.css">
</head>
<body>

	<div class="container">
	
		<h1><c:out value="${team.teamName}" /></h1>

		<a href="/home">Dashboard</a>
		
		<p>Team Name: <c:out value = "${team.teamName}"/></p>
		
		<p>Added By: <c:out value = "${user.userName}"/></p>

		<p>Skill Level: <c:out value = "${team.skillLevel}"/></p>

		<p>Game Day: <c:out value = "${team.gameDay}"/></p>
		
		<c:choose>
			<c:when test="${user.id eq team.user.id}">
				<a href="/teams/${team.id}/edit">Edit</a>
				<form action="/teams/${team.id}/delete" method="post">
					<input type="submit" value="Delete">
				</form>
			</c:when>
			<c:otherwise>
			
			</c:otherwise>
		</c:choose>

	</div>

</body>
</html>