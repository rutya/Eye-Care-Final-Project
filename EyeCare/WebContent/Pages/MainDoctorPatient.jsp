<!-- This page accepts the card id of patient to display the report of that patient to main doctor -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Doctor Patient</title>
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
					<ul>
					</ul>
				</div>

			</div>




			<div id="middle_box">
				<div class="middle_box_content">
					<img src="images/cdd.jpg" alt="" title="" width="550" height="170" />
				</div>
			</div>
			<!--     <div class="header"> -->
			<div class="middle_box2" style="background-color: white">
				<div class="middle_box_content">

					<center>Welcome to Main Doctor Page.</center>

					<form action="/EyeCare/ViewReportToMainDoctor" method="post">
						<table align="center">
							<tr>
								<td><label>Card Id:</label></td>
								<td><input type="text" name="cardid" required /></td>
							</tr>

							<tr>
								<td colspan="2"><input type="Submit" value="ViewReport"
									style="margin-left: 90px;" /></td>
							</tr>

						</table>
					</form>
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
