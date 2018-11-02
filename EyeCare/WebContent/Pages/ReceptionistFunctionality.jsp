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
						<li><a href="/EyeCare/Pages/NewPatientRegistration.jsp"
							title="">NewPatientReg</a></li>

						<li><a href="/EyeCare/Pages/CardLost.jsp" title="">CardLost</a></li>
						<li><a href="/EyeCare/Pages/DisplayCardDetails.jsp" title="">ShowCard</a></li>


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


					<form action="/EyeCare/LogOut" method="post">
						<table align="center">


							<tr>
								<td colspan="2"><input type="Submit" value="Logout"
									style="margin-left: 30px;" /></td>
							</tr>

						</table>
					</form>

				</div>
			</div>
		</div>

	</div>
</body>
</html>
