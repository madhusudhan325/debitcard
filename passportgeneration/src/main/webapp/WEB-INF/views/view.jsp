<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Person Data</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<script>
	function validate() {
		var passport = document.getElementById("passportId").value;
		if (passport != 7) {
			alert("enter valid passport Id");
			return false;
		}
	}
</script>
<style>
body {
	background-image:
		url('https://image.freepik.com/free-vector/green-cricket-sports-background-with-illustration-players-golden-trophy-cup_1302-5494.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	background-size: 100% 100%;
}
</style>
</head>
<body>
	<h1>Person Details</h1>
	<hr>
	<div class="form">
		<form action="/showdata" method="get" onsubmit="validate()">
			<table class="table">
				<tr class="table-primary">
					<td>Enter Passport Id</td>
					<td><input id="passportId" name="passportId"></td>
				</tr>
				<tr class="table-success">
					<td>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>
	<table class="table table-dark table-hover" border="2" width="70%"
		cellpadding="2">
		<tr>
			<th class="table-success">FIRSTNAME</th>
			<th class="table-success">LASTNAME</th>
			<th class="table-primary">AGE</th>
			<th class="table-primary">COUNTRY</th>
			<th class="table-primary">PASSPORTID</th>
		</tr>
		<c:forEach var="person" items="${result}">
			<tr class="info">
				<td>${person.firstName}</td>
				<td>${person.lastName}</td>
				<td>${person.age}</td>
				<td>${person.country}</td>
				<td>${person.passportId}</td>
			</tr>

		</c:forEach>
	</table>
	<a href="/">
		<button>back</button>
	</a>
</body>
</html>