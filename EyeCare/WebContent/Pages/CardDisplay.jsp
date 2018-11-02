<!-- This page displays the card details of patient as card id,name of card holder,mobile number,address,age,issue date,due date -->

<%@page import="com.model.CardDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Card Display Page</title>
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
</head>
<body>


	<center>
		<h2>Card Details</h2>
	</center>
	<br>
	<br>
	<%
		Object object = request.getAttribute("cardDetails");
		CardDetails card = (CardDetails) object;
	%>
	<table align="center" border=1.0>
		<tr>
			<td>Card Id</td>
			<td><%=card.getPatient().getCardId()%></td>
		</tr>
		<tr>
			<td>Patient Name</td>
			<td><%=card.getPatient().getPatientName()%></td>
		</tr>
		<tr>
			<td>Patient Age</td>
			<td><%=card.getPatient().getAge()%></td>
		</tr>
		<tr>
			<td>Mobile No</td>
			<td><%=card.getPatient().getMobileNo()%></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><%=card.getPatient().getAddress()%></td>
		</tr>
		<tr>
			<td>IssueDate</td>
			<td><%=card.getIssueDate()%></td>
		</tr>
		<tr>
			<td>DueDate</td>
			<td><%=card.getDueDate()%></td>
		</tr>
	</table>
	<br>
	<br>

	<form action="/EyeCare/LogOut" method="post">
		<table align="center">


			<tr>
				<td colspan="2"><input type="Submit" value="Logout"
					style="margin-left: 90px;" /></td>
			</tr>

		</table>
	</form>
	<form action="/EyeCare/Pages/ReceptionistFunctionality.jsp" method="post">
		<table align="center">


			<tr>
				<td colspan="2"><input type="Submit" value="Back"
					style="margin-left: 30px;" /></td>
			</tr>

		</table>
	</form>
</body>
</html>
