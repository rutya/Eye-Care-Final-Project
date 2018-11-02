<!-- This page accepts name and mobile number of patient whose card is lost -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CardLost</title>
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
						<li><a href="/EyeCare/Pages/Logout.jsp" title="">Logout</a></li>


					</ul>
				</div>

			</div>




			<div id="middle_box">
				<div class="middle_box_content">
					<img src="images/r.jpg" alt="" title="" width="880" height="170" />
				</div>
			</div>


			<center>Welcome to Card Lost Page.</center>

			<form action="/EyeCare/CardLost" method="post">
				<table align="center">
					<tr>
						<td><label>Name:</label></td>
						<td><input type="text" name="name" required /></td>
					</tr>

					<tr>
						<td><label>Phone No:</label></td>
						<td><input type="text" name="phoneno" required /></td>
					</tr>

					<tr>
						<td colspan="2"><input type="Submit" value="Submit"
							style="margin-left: 90px;" /></td>
					</tr>

				</table>
		</div>


		<div id="main_content">
			<div class="clear"></div>
		</div>


		<div id="footer">
			<div class="copyright">
				<img src="images/footer_logo.gif" alt="" title="" />
			</div>
			<div class="center_footer">&copy; Eye Care Clinic 2018. All
				Rights Reserved</div>
			<div class="footer_links">
				<a href="http://csstemplatesmarket.com"><img
					src="images/csstemplatesmarket.gif" alt="csstemplatesmarket"
					title="csstemplatesmarket" border="0" /></a>
			</div>


		</div>

	</div>

</body>
</html>
