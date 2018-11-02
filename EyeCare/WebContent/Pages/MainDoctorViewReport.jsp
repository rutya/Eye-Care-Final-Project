<!-- This page displays the report to main doctor and then main doctor can suggest treatment or operation if required -->

<%@page import="java.util.Collections"%>
<%@page import="java.util.HashSet"%>
<%@page import="com.serviceLayer.OperationDetailsService"%>
<%@page import="com.model.OperationDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page import="com.model.CheckupDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Doctor View Report</title>
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
</head>
<body>
<div id="main_container">
	<div class="header">
    	<div id="logo"><a href="Logout.jsp"><img src="images/EyeCareLogo.png" alt="" title="" width="162" height="54" border="0" /></a></div>
    
    	<div class="right_header">
    	
    	 <div class="top_menu">
    	 <a href="#" class="">   </a>
    	 <a href="#" class="">    </a>
            </div>
            <div id="menu">
                <ul>                                              
                </ul>
            </div>
        
        </div>
    
    </div>
    
    
    <div id="middle_box">
    	<div class="middle_box_content"><img src="images/cdd.jpg" alt="" title="" width="550" height="170"/></div>
    </div>
<!--     <div class="header"> -->
<div class="middle_box2" style="background-color:white" >
<div class="middle_box_content">

<center>
<%
    Object object = request.getAttribute("checkupDetails");
    CheckupDetails checkupdetails =(CheckupDetails) object;
%>
   	
<table border=1.0>
<tr><td>Card ID</td><td>Left Eye Number</td><td>Right Eye Number</td><td>Glasses Granted Status</td><td>Suggested Treatment By Junior Doctor</td></tr>

<tr>
<td><%=checkupdetails.getPatient().getCardId()%> </td>
<td><%=checkupdetails.getLeftEyeNo() %></td>
<td><%=checkupdetails.getRightEyeNo() %></td>
<td><%=checkupdetails.getGlassesGrantedStatus() %></td>

<td><%=checkupdetails.getSuggestedTreatment() %></td>
</tr>
</table>

</center>
<form action="/EyeCare/UploadMainDoctorReport" method="post">
<%int cardid=checkupdetails.getPatient().getCardId();%>
<input type="hidden" name="CardId" value=<%=checkupdetails.getPatient().getCardId()%> />
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
             </tr><tr>
             </tr>
             <tr>
             </tr><tr>
             </tr>
             <tr>
             </tr><tr>
             </tr>
             <tr>
             </tr><tr>
             </tr>
             <tr>
             </tr><tr>
             </tr>
             <tr>
             </tr>
             <tr>
									<td><label> Treatment Name:<font color="#008B8B">*</font></label></td>
									<%
									OperationDetailsService operationdetailsservice = new OperationDetailsService(); 
									List<OperationDetails> operationList =operationdetailsservice.getAllOpeartionDetails(); 
									List<String> treatmentNameList = new ArrayList<String>();
									
									
									
									%>
									
									<td><select name="treatment">
									<%for(OperationDetails operation : operationList)
									{
										
											System.out.println("in else :"+operation);
											treatmentNameList.add(operation.getOpeartionName().trim());
										
									}
									treatmentNameList = new ArrayList<String> ( new HashSet<String>(treatmentNameList));
									
									System.out.println(treatmentNameList);
									
									for(String treatmentName : treatmentNameList)
									{%>
										<option><%=treatmentName%></option>
									<% }%> 
									
								</select></td>			
								</tr>
								
								
									<tr>
			
				<td><label>Operation Date:</label></td>
				<td><input type=text  name="OperationDate" placeholder="YYYY-MM-DD" /></td>
			</tr>
        
             
             	<tr>
				<td colspan="2"><input type="Submit" value="Submit"
					style="margin-left: 90px;" /></td>
					
			</tr>
             
             
             
             

</table>


</form>

<form action="/EyeCare/LogOut" method="post">
<table align="center">
		
			
			<tr>
				<td colspan="2"><input type="Submit" value="Logout"
					style="margin-left: -20px;" /></td>
			</tr>
			
</table>
</form>
</div>
</div>
</div>
</body>
</html>
