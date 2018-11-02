<!-- This page displays the patient details and gives edit details option  -->

<%@page import="com.model.PatientDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EditDetails</title>
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
</head>
<body>

	<div class="middle_box2" style="background-color: white">
		<div class="middle_box_content">
			<%
				Object attr = request.getAttribute("patientDetails");
				PatientDetails patient = (PatientDetails) attr;
				request.setAttribute("patient", patient);
			%>
			<center>
				<h2>Patient Details</h2>
			</center>
			<br>
			<br>
			<table align="center" border=1.0>

				<tr>
					<td>Card ID</td>
					<td><%=patient.getCardId()%></td>
				</tr>
				<tr>
					<td>Patient Name</td>
					<td><%=patient.getPatientName()%></td>
				</tr>
				<tr>
					<td>Patient Age</td>
					<td><%=patient.getAge()%></td>
				</tr>
				<tr>
					<td>Mobile Number</td>
					<td><%=patient.getMobileNo()%></td>
				<tr>
				<tr>
					<td>Address</td>
					<td><%=patient.getAddress()%></td>
				</tr>
			</table>
			<br>
			<form action="/EyeCare/Pages/EditDetailsForm.jsp" method="post">
				<table align="center">


					<tr>
						<td colspan="2"><input type="Submit" value="EditDetails"
							style="margin-left: 90px;" /></td>
					</tr>

				</table>
				<br>
			</form>
			<form action="/EyeCare/LogOut" method="post">
				<table align="center">


					<tr>
						<td colspan="2"><input type="Submit" value="Logout"
							style="margin-left: 90px;" /></td>
					</tr>

				</table>
			</form>
		</div>
	</div>

</body>
</html>
