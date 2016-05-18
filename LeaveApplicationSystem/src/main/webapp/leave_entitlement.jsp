<%@ page import="com.pactera.bean.*,java.util.List,com.pactera.dao.*" %>

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
    function addLeave() {
        location.href = "add_leave_entitlement.do";
    };
</script>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Leave Entitlement Page</title>
</head>
<body>



<div id="wrapper">

    <div id="header">

        <h1>Pactera : Leave Application System</h1>s
		
    </div>

    <div id="page-body">

<%@ include file="links.jsp" %>

        <div id="content">
        
        <%
			//DaoFactory daoFactory = null;
			//daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
			//LeaveEntitlementDao leaveDao = daoFactory.getLeaveEntitlementDao();
			
			//List<LeaveEntitlementBean> listOfLeave = (List<LeaveEntitlementBean>) leaveDao.retrieveAllUser();
			
			List<LeaveEntitlementBean> listOfLeave = (List<LeaveEntitlementBean>) request.getAttribute("listOfLeave");

		%>
    <form method="post" action="leaveentitlement.do">
    
    	<table width="100%" border=0>
  		<tr>
    		<h2>Leave Entitlement</h2>
			<td align="right"><button type="button" onclick="addLeave()" >Add Leave Entitlement</button></td>
  		</tr>
	</table>
	<hr>
	<br>
	<hr color="black">
	
	<table width="100%">
		<tr height="30" bgcolor="blue" style="color:white">
			<th>Leave Type</th>
			<th>Criteria From</th>
			<th>Criteria Until</th>
			<th>Employee Grade</th>
			<th>No of Days</th>
			<th>Action</th>
		</tr>
		<% 
        	for (LeaveEntitlementBean leave : listOfLeave) {
        %>
		<tr>
			<td><%= leave.getLeaveType() %></td>
			<td><%= leave.getCriteriaFrom() %></td>
			<td><%= leave.getCriteriaUntil() %></td>
			<td><%= leave.getEmpGrade() %></td>
			<td><%= leave.getDays() %></td>
			<td align="center"><button><a href="update_leave_entitlement.do?leave_entitlement_id=<%= leave.getLeaveEntitlementId() %>">Edit</a></button></td>
		</tr>
		<%
        	}
        %>
	</table> 	
    	
    </form>
	
        </div>

    </div>

    

    <div id="footer">

        <p>Copyright &#169; 2016 pactera.com. All rights reserved.</p>

    </div>

</div>
	<hr color="black">
</body>
</html>