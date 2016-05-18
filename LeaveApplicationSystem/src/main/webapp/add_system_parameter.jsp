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
        location.href = "system_parameter.do";
    };
</script>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add System Parameter Page</title>
</head>
<body>



<div id="wrapper">

    <div id="header">

        <h1>Pactera : Leave Application System</h1>
		
    </div>

    <div id="page-body">

<%@ include file="links.jsp" %>

        <div id="content">

			<h2>Add System Parameter</h2>
			<br>
	
	<div>
	<form action="add_system_parameter.do" method="post">
	<table width="100%" border="0">
		<tr>
			<td width="150px">Parameter Type</td>
			<td>:</td>
			<td><select name="paramType" id="paramType">
					<option value="">Please select</option>
					<option value="Leave Type">Leave Type</option>
					<option value="Department">Department</option>
					<option value="Employee Grade">Employee Grade</option>
				</select>
			</td>
		</tr>
	
		<tr>
			<td width="150px">Code</td>
			<td>:</td>
			<td><input type="text" name="paramCode" id="paramCode"></input></td>
		</tr>
		
		<tr>
			<td width="150px">Description</td>
			<td>:</td>
			<td><input type="text" name="desc" id="desc"></input></td>
		</tr>
		
		<tr>
			<td width="150px"></td>
			<td></td>
			<td><button value="Create" type="submit">Create</button>&emsp;<button value="Cancel" type="button" onclick="goBack()">Cancel</button></td>
		</tr>	
	</table>
	
	</form>
	</div>
	<br>
        </div>

    </div>

    <div id="footer">

        <p>Copyright &#169; 2016 pactera.com. All rights reserved.</p>

    </div>

</div>



    
	 
</body>
</html>