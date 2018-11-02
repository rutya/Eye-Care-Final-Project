<!-- This Page Displays the options like Appointment,RenewCard,ViewPatientDetails and MachineEyeCheckup to receptionist if patient is already registered  -->



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AlreadyRegistered</title>
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
						<li><a class="" href="/EyeCare/Pages/Appointment.jsp"
							title="">Appointment</a></li>
						<li><a href="/EyeCare/Pages/RenewCard.jsp" title="">RenewCard</a></li>
						<li><a href="/EyeCare/Pages/ViewPatientDetails.jsp" title="">ViewPatientDetails</a></li>
						<li><a href="/EyeCare/Pages/MachineEyeCheckup.jsp" title="">
								MachineEyeCheckup</a></li>
					</ul>
				</div>
			</div>

			<div id="middle_box">
				<div class="middle_box_content">
					<img src="images/r.jpg" alt="" title="" width="880" height="170" />
				</div>
			</div>
			<div class="middle_box2">
				<div class="middle_box_content">


					<form action="/EyeCare/LogOut" method="post">
						<table align="center" height="">


							<tr>
								<td colspan="2"><input type="Submit" value="Logout"
									style="margin-left: 60px;" /></td>
							</tr>

						</table>
					</form>
					<br>
					<form action="/EyeCare/Pages/ReceptionistFunctionality.jsp"
						method="post">
						<table align="center">


							<tr>
								<td colspan="2"><input type="Submit" value="Back"
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
