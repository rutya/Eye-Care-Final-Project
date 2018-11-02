<!-- This page displays the left eye number and right eye number of patient -->

<%@page import="com.model.CheckupDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Patient Eye Details</title>
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






			</div>




			<div id="middle_box">
				<div class="middle_box_content">
					<img src="images/eg.png" alt="" title="" width="950" height="170" />
				</div>
			</div>
			<div class="header">
				<center>
					<h2>Patient Report</h2>
					<%
						Object object = request.getAttribute("checkupDetails");
						CheckupDetails checkupdetails = (CheckupDetails) object;
					%>

					<table border=1.0>
						<tr>
							<td>Card ID</td>
							<td>Left Eye Number</td>
							<td>Right Eye Number</td>
						</tr>

						<tr>
							<td><%=checkupdetails.getPatient().getCardId()%></td>
							<td><%=checkupdetails.getLeftEyeNo()%></td>
							<td><%=checkupdetails.getRightEyeNo()%></td>
						</tr>
					</table>

				</center>

				<form action="/EyeCare/UploadGlassesGrantedStatus" method="post">

					<table align="center">
						<tr>
						</tr>
						<tr>
						</tr>
						<tr>
						</tr>
						<tr>
						</tr>
						<tr>
						</tr>
						<tr>
							<td><input type="checkbox" name="glassstatus" size="100pt">
							</td>
							<td><label>Glasss Granted</label></td>
						</tr>
						<tr>
							<td><input type="submit" value="Submit"></td>
						</tr>

					</table>


				</form>
				<center>
					<form action="/EyeCare/Pages/AfterEyeGlassLogin.jsp" method="post">
						<table align="center">


							<tr>
								<td colspan="2"><input type="Submit" value="Back"
									style="margin-left: 30px;" /></td>
							</tr>

						</table>
					</form>
				</center>

			</div>
		</div>


	</div>
</body>
</html>
