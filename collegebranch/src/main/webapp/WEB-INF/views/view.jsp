<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>
	<h1>College Branch Details</h1>
	<hr>
	<div class="form">
		<form action="/getdata" method="get">
			<table class="table">
				<tr>
				<tr class="table-primary">
					<td>Select College</td>
					<td><select name="collegeName" id="collegeName"
						data-toggle="dropdown" size="1">
							<c:forEach var="college" items="${colleges}">
								<option>${college.collegeName}</option>
							</c:forEach>
					</select></td>

				</tr>


				<tr class="table-success">
					<td>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>
	<table class="table-active" border="2" width="70%" cellpadding="2">
		<tr>
			<th class="table-success">BRANCH NAME</th>
			<th class="table-warning">TOTAL STRENGTH</th>
			<th class="table-primary">HOD NAME</th>
			<th class="table-danger">Update</th>

		</tr>
		<c:forEach var="branch" items="${branchs}">
			<tr class="info">
				<td>${branch.branchName}</td>
				<td>${branch.branchTotalStrength}</td>
				<td>${branch.hodName}</td>
				<td><a href="/update/${branch.branchId}">Update</a>
			</tr>

		</c:forEach>
	</table>
	<div>
		<c:set var="total" value="${0}" />
		<c:forEach var="branch" items="${branchs}">
			<c:set var="total" value="${total + branch.branchTotalStrength}" />
		</c:forEach>
		<c:if test="${total!=0}">
			<h3>Total Strength :${total}</h3>
		</c:if>
	</div>
	<a href="/">
		<button>back</button>
	</a>
</body>
</html>