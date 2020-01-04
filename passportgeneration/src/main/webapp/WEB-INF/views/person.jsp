<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Person data page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
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
<style>
.container {
	max-width: 800px;
	padding: 50px 70px;
	background-color: beige;
	border-radius: 10px;
	opacity: 0.9;
}

/* html {
	background-blend-mode: overlay;
	background-color: azure;
	display: inline;
	justify-content: center;
	opacity: 0.9;
}
 */</style>
</head>
<body>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="container">
				<form action="/addPerson" method="post" onsubmit="return validate()"
					id="form">
					<h2>Passport Application</h2>
					<div class="form-group">
						<label for="firstName">First Name :</label> <input type="text"
							class="form-control item" name="firstName" id="firstName">
					</div>
					<div class="form-group">
						<label for="lastName">Last Name :</label> <input type="text"
							class="form-control item" name="lastName" id="lastName">
					</div>
					<div class="form-group">
						<label for="age">Age :</label> <input type="number"
							class="form-control item" name="age" id="age">
					</div>
					<div class="form-group">
						<label for="country">country :</label> <input type="text"
							class="form-control item" name="country" id="country">
					</div>

					<div>
						<button type="submit" class="btn-success create button">Register</button>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>
	<script>
		$('form').validate({

			rules : {
				firstName : {
					required : true,
					minlength : 6,
					lettersonly : true
				},
				lastName : {
					required : true,
					minlength : 6,
					lettersonly : true
				},
				age : {
					required : true,
					number : true
				},
				country : {
					required : true,
					lettersonly : true
				}
			}

		});
	</script>
</body>
</html>