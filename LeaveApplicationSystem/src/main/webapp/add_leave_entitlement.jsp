<%@ page import="com.pactera.bean.*,java.util.List,com.pactera.dao.*"  %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta http-equiv="Content-Language" content="en-us" />

<title>Leave Application System</title>

<meta name="Author" content="" />

<meta name="Description" content="Leave Application System" />

<meta name="Keywords" content="pactera" />

<style type="text/css" media="screen" xml:space="preserve">
/*<![CDATA[*/
@import url("css/default.css");
/*]]>*/
</style>

<script>
    function goBack() {
        location.href = "leaveentitlement.do";
    };
</script>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add Leave Entitlement</title>
</head>
<body>

	
<div id="wrapper">

    <div id="header">

        <h1>Pactera : Leave Application System</h1>
		
    </div>

    <div id="page-body">

<%@ include file="links.jsp" %>

        <div id="content">
	
		<%			
			List<ParameterBean> listOfParam = (List<ParameterBean>) request.getAttribute("listOfParam");
		%>
	
			 <h2>Add Leave Entitlement Page</h2>
			 <br>
	
	<div>
	
	<form method="post" action="add_leave_entitlement.do" >
	<table width="100%" border="0">
		<tr>
			<td width="150px">Leave Type</td>
			<td>:</td>
			<td><select name="leaveType" id="leaveType">
					<option value="">Please select</option>
					<% for(ParameterBean list : listOfParam){ 
					
						if(list.getParameterType().equals("Leave Type")){%>
					
						<option value="<%= list.getDesc()%>"><%= list.getDesc()%></option>
					
					<% }}%>		
				</select>
			</td>
		</tr>
	
		<tr>
			<td width="150px">Criteria From</td>
			<td>:</td>
			<td><input name="criteriaFrom" id="criteriaFrom" type="number"></input></td>
		</tr>
		
		<tr>
			<td width="150px">Criteria Until</td>
			<td>:</td>
			<td><input name="criteriaUntil" id="criteriaUntil" type="number"></input></td>
		</tr>
		
		<tr>
			<td width="150px">Employee Grade</td>
			<td>:</td>
			<td><select name="empGrade" id="empGrade">
					
					<option value="">Please select</option>
					<% for(ParameterBean list : listOfParam){ 
					
						if(list.getParameterType().equals("Employee Grade")){%>
					
						<option value="<%= list.getParameterCode()%>"><%= list.getParameterCode()%></option>
					
					<% }}%>				
				</select>
			</td>
		</tr>
		
		<tr>
			<td width="150px">No. Leave Entitlement</td>
			<td>:</td>
			<td><input name="noLeave" id="noLeave" type="number"></input></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td><button value="create" type="submit">Create</button>&emsp;<button value="cancel" type="button" onclick="goBack()">Cancel</button></td>
		</tr>
		
	</table>
	</form>
	</div>
			
        </div>

    </div>

    <div id="footer">

        <p>Copyright &#169; 2016 pactera.com. All rights reserved.</p>

    </div>

</div>
	 
</body>
</html>