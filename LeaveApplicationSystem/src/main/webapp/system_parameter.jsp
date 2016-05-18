<%@ page import="com.pactera.bean.*, com.pactera.dao.*, java.util.*" %>
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
	function addSystemParameter(){
		location.href = "add_system_parameter.do";
	}
</script>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>System Parameter Page</title>
</head>
<%
	List<ParameterBean> listOfParam = (List<ParameterBean>) request.getAttribute("listOfParam");
%>

<body>


<div id="wrapper">

    <div id="header">

        <h1>Pactera : Leave Application System</h1>
		
    </div>

    <div id="page-body">

<%@ include file="links.jsp" %>

        <div id="content">

<table width="100%" border=0>
  		<tr>
    		<h2>System Parameter</h2>
			<td align="right"><button type="button" onclick="addSystemParameter()">Add System Parameter</button></td>
  		</tr>
	</table>
	<hr color="black">
	<br>
	<form method="post" action="system_parameter.do">
	<table width="100%">
		<tr height="30" bgcolor="blue" style="color:white">
			<th>Type</th>
			<th>Code</th>
			<th>Description</th>
			<th>Action</th>
		</tr>
		<% 
        	for (ParameterBean list : listOfParam) {
        %>
		<tr>
			<td><%= list.getParameterType() %></td>
			<td><%= list.getParameterCode() %></td>
			<td><%= list.getDesc() %></td>
			<td align="center"><button><a href="update_system_parameter.do?parameter_id=<%= list.getParameterId() %>">Edit</a></button></td>
		</tr>
		<% } %>
	</table>
	</form>
	</div>  	

    </div>
    <div id="footer">

        <p>Copyright &#169; 2016 pactera.com. All rights reserved.</p>

    </div>



	
	</div>

</body>
</html>