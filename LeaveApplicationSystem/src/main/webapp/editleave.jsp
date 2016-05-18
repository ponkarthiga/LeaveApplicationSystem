<%@page import="com.pactera.bean.LeaveBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta http-equiv="Content-Language" content="en-us" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">

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
	$(document).ready(function() {
		$( "#datepicker" ).datepicker();
		$( "#datepicker1" ).datepicker();
		$( "#datepicker2" ).datepicker();
	});
   	
</script>

</head>
<body>
<div id="wrapper">

    <div id="header">

        <h1>Pactera : Leave Application System</h1>

    </div>

    <div id="page-body">

		<%@ include file="links.jsp" %>
		<%
			LeaveBean leaveBean = (LeaveBean) request.getAttribute("leaveBean");
		leaveBean = (leaveBean == null) ? new LeaveBean() : leaveBean;
		%>
		<h2>Edit Leave</h2>
		<form method="post" action="updleave.do">
		<div>
		<table>
          		<tbody>
          			<tr>
          				<td>ID</td>
          				<td>
          					<%=leaveBean.getLeaveId() %>
          					<input type="hidden" name="leaveId" value="<%=leaveBean.getLeaveId() %>" />
          				</td>
          			</tr>

<tr>
          				<td>Leave Type</td>
          				<td><input type="text" name="leaveType" value="<%=leaveBean.getLeaveType() %>"/></td>
          			</tr>
          			<tr>
          				<td>Leave Duration</td>
          				<td><input type="text" name="ldur" value="<%=leaveBean.getLeaveDur() %>"/></td>
          			</tr>

					<tr>
          				<td>Leave Date</td>
          				<td><input type="text" name="ldate" value="<%=leaveBean.getLeaveDate() %>" id="datepicker"/></td>
          			</tr>
          			<tr>
          				<td>Leave From</td>
          				<td><input type="text" name="leavefrom" value="<%=leaveBean.getLeaveFrom() %>" id="datepicker1"/></td>
          			</tr>
          			<tr>
          				<td>Leave To</td>
          				<td><input type="text" name="leaveto" value="<%=leaveBean.getLeaveTo() %>" id="datepicker2"/></td>
          			</tr>
          			<tr>
          				<td><input type="submit" value="Update" /></td>
          				<td></td>
          			</tr>
          		</tbody>
          	</table>
          </form>


		</div>
	
		<div id="footer">

       		<p>Copyright &#169; 2016 pactera.com. All rights reserved.</p>

    	</div>
	</div>
	</body>
</html>