<!-- Login page -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is Login Page</title>
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
					<a href="#" class=""> </a> <a href="#" class=""> </a> <a
						href="/EyeCare/Pages/Login.jsp" class="login">EyeGlass</a>

				</div>




				<div id="menu">
					<ul>
						<li><a class="" href="/EyeCare/Pages/Login.jsp" title="">Home</a></li>
						<li><a href="/EyeCare/Pages/Login.jsp" title="">Receptionist</a></li>
						<li><a href="/EyeCare/Pages/Login.jsp" title="">Junior
								Doctor</a></li>
						<li><a href="/EyeCare/Pages/Login.jsp" title="">Main
								Doctor</a></li>


					</ul>
				</div>

			</div>




			<div id="middle_box">
				<div class="middle_box_content">
					<img src="images/wallpaper1.jpg" alt="" title="" width="880"
						height="170" />
				</div>
			</div>
			<!--     <div class="header"> -->
			<div class="middle_box2" style="background-color: white">
				<div class="middle_box_content">
					<center>Welcome to Login Page.</center>
					<form action="/EyeCare/LoginChecker" method="post">
						<table align="center">

							<tr>
								<td><label> Username:</label></td>
								<td><input type="text" name="username" required /></td>
							</tr>
							<tr>
								<td><label> Password:</label></td>
								<td><input type="password" name="password" required /></td>
							</tr>
							<tr>
								<td colspan="2"><input type="Submit" value="Login"
									style="margin-left: 90px;" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>

			<div class="pattern_bg">

				<div class="pattern_box">
					<div class="pattern_box_icon">
						<img src="images/icon1.png" alt="" title="" width="70"
							height="112" />
					</div>
					<div class="pattern_content">
						<h1>
							WORKING HOURS <span class="blue"></span>
						</h1>
						<p class="pat">

							MON: 9:30 AM - 05:00 PM <br /> TUES: 9:30 AM - 05:00 PM <br />
							WED: 9:30 AM - 05:00 PM <br /> THUR: 9:30 AM - 05:00 PM <br />
							FRI: 9:30 AM - 05:00 PM <br /> SAT: 10:00 AM - 01:00 PM <br />
						</p>
					</div>
				</div>


				<div class="pattern_box">
					<div class="pattern_box_icon">
						<img src="images/icon2.png" alt="" title="" width="70"
							height="112" />
					</div>
					<div class="pattern_content">
						<h1>
							Get in Touch <span class="blue"></span>
						</h1>
						<p class="pat">
							Janhavi Swami -9563125685 <br /> Swati Londhe -9975478414 <br />
							Rutuja KulKarni -9956234585 <br /> Sheetal Deshmukh -9763861049 <br />
						</p>
					</div>
				</div>


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

	</div>
</body>
</html>
