<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<title>home </title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>

	<div class="center-heading">
		<h1> Welcome , <c:out value="${user.userName}" /></h1>
		<form action="/logout" method="post">
		<button type="submit">Logout</button>
		</form>
	</div>
	<div class="table_container">
		<table>
			<thead>
				<tr>
					<th>Team Name</th>
					<th>Skill Level</th>
					<th>Game Day</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="team" items="${teams}">
					<tr>
						<td><a href="/teams/${team.id}"><c:out value="${team.teamName}" /></a></td>
						<td><c:out value="${team.skillLevel}" /></td>
						<td><c:out value="${team.gameDay}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="button">
			<form action="/addPage" method="get">
			<input type="submit" value = "Create New Team"/>
			</form>
		</div>
	</div>
</body>
</html>