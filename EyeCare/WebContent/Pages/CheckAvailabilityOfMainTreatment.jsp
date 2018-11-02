<!-- This page gives the list of suggested hospital names if treatment is not available -->

<%@page import="java.util.List"%>
<%@page import="com.model.OperationDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Operation Status</title>
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
					<center>

						<%
	Object object=request.getAttribute("available");
	String status=object.toString();
	System.out.println(status);
	if(status.equals("available"))
	{
%>
						<h2>Thank you for taking Service...</h2>
						<%}else { %>
					</center>
					<form action="/EyeCare/UploadSuggestedHospitalName" method="post">
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
							</tr>
							<tr>
							</tr>
							<tr>
							</tr>
							<tr>
								<td><label>Sorry...But this Service is not
										available in our Hospital.</label></td>
							</tr>
							<tr>
								<td><label> Suggested Hospital Name :<font
										color="#008B8B">*</font></label></td>
								<td><select name="Hospitalname">
										<%
										Object objectlist=request.getAttribute("operationalDetailsList"); 
										List<OperationDetails> operationList = (List<OperationDetails>) objectlist;
										for(OperationDetails operationdetails: operationList)
									{%>
										<option><%=operationdetails.getHospitalName()%></option>
										<%} %>
								</select></td>

							</tr>
							<tr>
							</tr>
							<tr>
							</tr>

							<tr>
								<td colspan="2"><input type="Submit"
									value="Send All Data To Referred Hospital"
									style="margin-left: 90px;" /></td>

							</tr>
						</table>
					</form>

					<%} %>

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
