<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add team</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="container">
		<h1>edit Team</h1>
		<p><a href="/home"> Dashboard</a></p>
		<form:form action="/teams/${id}/edit" method="post" modelAttribute="team">
			<p>
				<form:label path="teamName">Team Name</form:label>
				<form:errors path="teamName"/>
				<form:input path="teamName"  value = "${team.teamName}"/>
			</p>
			<p>
				<form:label path="skillLevel">Skill Level(1-5)</form:label>
				<form:errors path="skillLevel"/>
				<form:input path="skillLevel" value = "${team.skillLevel}" />
			</p>
			<p>
				<form:label path="gameDay">Game Day</form:label>
				<form:errors path="gameDay"/>
				<form:input path="gameDay"  value = "${team.gameDay}" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>

</body>
</html>