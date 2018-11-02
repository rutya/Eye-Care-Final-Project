<!-- This page accepts appointment date and appointment time to give an appointment to patient -->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appointment</title>
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


					</ul>
				</div>

			</div>

			<div id="middle_box">
				<div class="middle_box_content">
					<img src="images/r.jpg" alt="" title="" width="880" height="170" />
				</div>
			</div>
			<!--     <div class="header"> -->


			<div id="middle_box2" style="background-color: white">
				<div class="middle_box_content">
					<center>Welcome to Appointment Page.</center>
					<form action="/EyeCare/ConfirmAppointment" method="post">
						<table align="center">
							<tr>
								<td><label>Card Id:</label></td>
								<td><input type="text" name="cardid" required /></td>
							</tr>
							<tr>

								<td><label>Appointment Date:</label></td>
								<td><input type=text name="AppointmentDate"
									placeholder="YYYY-MM-DD" required /></td>
							</tr>
							<tr>
							<tr>
								<td><label>Select Time Slot:<font color="#008B8B">*</font></label></td>
								<td><select name="appointmenttime">
										<option id=1>10-11</option>

										<option>11-12</option>
										<option>12-1</option>
										<option>1-2</option>
										<option>2-3</option>
										<option>3-4</option>
										<option>4-5</option>
										<option>5-6</option>


								</select></td>
							</tr>

							<tr>
								<td colspan="2"><input type="Submit"
									value="Confirm Appointment" style="margin-left: 90px;" /></td>
							</tr>
						</table>
					</form>
					<form action="/EyeCare/LogOut" method="post">
						<table align="center">


							<tr>
								<td colspan="2"><input type="Submit" value="Logout"
									style="margin-left: 90px;" /></td>
							</tr>

						</table>
					</form>

					<form action="/EyeCare/Pages/AlreadyRegistered.jsp" method="post">
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
