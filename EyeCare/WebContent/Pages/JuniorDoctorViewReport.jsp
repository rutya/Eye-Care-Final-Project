<!-- This page displays the report of an patient to junior doctor as his left eye number,right eye number and glasses granted status and also junior doctor can suggest the treatment if required and uploads the report-->

<%@page import="com.model.CheckupDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Junior Doctor View Report</title>
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

				<div class="top_menu">
					<a href="#" class=""> </a> <a href="#" class=""> </a>
				</div>
				<div id="menu">
					<ul></ul>
				</div>

			</div>

		</div>


		<div id="middle_box">
			<div class="middle_box_content">
				<img src="images/d.jpg" alt="" title="" width="580" height="170" />
			</div>
		</div>


		<center>
			<%
    Object object = request.getAttribute("checkupDetails");
    CheckupDetails checkupdetails =(CheckupDetails) object;
   	%>
			<center>
				<h2>Patient Report</h2>
			</center>
			<br>
			<table border=1.0>
				<tr>
					<td>Card ID</td>
					<td>Left Eye Number</td>
					<td>Right Eye Number</td>
					<td>Glasses Granted Status</td>
				</tr>

				<tr>
					<td><%=checkupdetails.getPatient().getCardId()%></td>
					<td><%=checkupdetails.getLeftEyeNo() %></td>
					<td><%=checkupdetails.getRightEyeNo() %></td>
					<td><%=checkupdetails.getGlassesGrantedStatus() %></td>
				</tr>
			</table>


		</center>

		<form action="/EyeCare/UploadJuniorDoctorReport" method="post">

			<br>
			<table align="center">
				<tr>
				<tr>
					<td><label>Suggested Treatment:<font color="#008B8B">*</font></label></td>
					<td><select name="treatment">


							<option>Corena Treatment</option>
							<option>Cataract Treatment</option>
							<option>Diabetic Treatment</option>
							<option>Squint Treatment</option>
							<option>Macular Treatment</option>
					</select></td>
				</tr>

				<tr>
					<td colspan="2"><input type="Submit" value="Upload Reports"
						style="margin-left: 90px;" /></td>

				</tr>





			</table>


		</form>

		<br>
		<form action="/EyeCare/LogOut" method="post">
			<table align="center">


				<tr>
					<td colspan="2"><input type="Submit" value="Logout"
						style="margin-left: -20px;" /></td>
				</tr>

			</table>
		</form>

		<form action="/EyeCare/Pages/JuniorDoctorPatient.jsp" method="post">
			<table align="center">


				<tr>
					<td colspan="2"><input type="Submit" value="Back"
						style="margin-left: 30px;" /></td>
				</tr>

			</table>
		</form>

	</div>
</body>
</html>
