<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NewPatientRegistration</title>
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
</head>
<body>
	<div id="main_container">
		<div class="header">
			<div id="logo">
				<a href="Logout.jsp"><img src="images/EyeCareLogo.png" alt=""
					title="" width="162" height="54" border="0" /></a>
			</div>

			<div class="right_header">
				<div id="menu">
					<ul>
						<li><a class="" href="/EyeCare/Pages/AlreadyRegistered.jsp"
							title="">AlreadyReg</a></li>
						<li><a href="/EyeCare/Pages/ReceptionistFunctionality.jsp"
							title="">NewPatientReg</a></li>

						<li><a href="/EyeCare/Pages/CardLost.jsp" title="">CardLost</a></li>
						<li><a href="/EyeCare/LogOut" title="">Logout</a></li>


					</ul>
				</div>

			</div>




			<div id="middle_box">
				<div class="middle_box_content">
					<img src="images/r.jpg" alt="" title="" width="880" height="170" />
				</div>
			</div>
			<!--     <div class="header"> -->
			<!-- <center> -->
			<!-- Welcome to Patient Registration Page. -->
			<!-- </center> -->

			<div class="middle_box2" style="background-color: white">
				<div class="middle_box_content">
					<form action="/EyeCare/NewPatientRegistration" method="post">
						<table align="center">


							<tr>
								<td><label>Name:</label></td>
								<td><input type="text" name="name" required /></td>
							</tr>
							<tr>
								<td><label>Age:</label></td>
								<td><input type="text" name="age" required /></td>
							</tr>

							<tr>
								<td><label>Mobile No:</label></td>
								<td><input type="text" name="mobile_No" required /></td>
							</tr>



							<tr>
								<td><label>Address:</label></td>
								<td><input type="text" name="address" required /></td>
							</tr>
							<tr>
								<td colspan="2"><input type="Submit" value="Register"
									style="margin-left: 90px;" /></td>
							</tr>




						</table>
					</form>




				</div>
			</div>
		</div>

	</div>
</body>
</html>
