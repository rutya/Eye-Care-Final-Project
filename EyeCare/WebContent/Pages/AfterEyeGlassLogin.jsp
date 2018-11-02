
<!-- This Page is used for accepting the Card ID  to display patient eye report-->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>After Eye Glass Login</title>
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
					<ul></ul>
				</div>

			</div>

			<div id="middle_box">
				<div class="middle_box_content">
					<img src="images/eg.png" alt="" title="" width="950" height="170" />
				</div>
			</div>
			<div class="middle_box2" style="background-color: white">
				<div class="middle_box_content">
					<center>Welcome to Eye Glass Service.</center>
					<br>
					<form action="/EyeCare/ViewReportToGlassShopKeeper" method="post">
						<table align="center" height="">
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
					<br>
					<form action="/EyeCare/LogOut" method="post">
						<table align="center" height="">


							<tr>
								<td colspan="2"><input type="Submit" value="Logout"
									style="margin-left: 60px;" /></td>
							</tr>

						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
