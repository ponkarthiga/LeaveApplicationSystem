<%@ page import="com.pactera.bean.*, com.pactera.dao.*, java.util.*" %>
<?xml version="1.0" encoding="utf-8"?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html lang="en-us" xml:lang="en-us" xmlns="http://www.w3.org/1999/xhtml">



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

LeaveEntitlementBean leave = (LeaveEntitlementBean) request.getAttribute("leaveBean");
leave = (null == leave) ? (new LeaveEntitlementBean()) : leave;

List<ParameterBean> listOfParam = (List<ParameterBean>) request.getAttribute("listOfParam");
%>
            <h2>Update Leave Entitlement</h2>
            
            <form method="post" action="update_leave_entitlement.do">
<table>
<tbody>
				<tr>
					<td>Leave Type</td>
					<td>:</td>
					<td><%= leave.getLeaveType() %></td>
				</tr>
				
				<tr>
					<td>Criteria From</td>
					<td>:</td>
					<td><input name="criteriaFrom" id="criteriaFrom" value="<%= leave.getCriteriaFrom() %>"></input></td>
				</tr>
				
				<tr>
					<td>Criteria Until</td>
					<td>:</td>
					
					<td><input name="criteriaUntil" id="criteriaUntil" value="<%= leave.getCriteriaUntil() %>"></input></td>
				</tr>
				
				<tr>
					<td>Employee Grade</td>
					<td>:</td>
					<td>
						<select name="empGrade" id="empGrade">
							<option value="<%= leave.getEmpGrade() %>" selected><%= leave.getEmpGrade() %></option>
								<% for(ParameterBean list : listOfParam){ 
									if(list.getParameterType().equals("Employee Grade")){%>
									<option value="<%= list.getParameterCode()%>"><%= list.getParameterCode()%></option>
								<% }}%>
							
							<!-- 
							<option value="B1">B1</option>
							<option value="B2">B2</option>
							 -->
						</select>
					</td>
				</tr>
				
				<tr>
					<td>No. Leave Entitlement</td>
					<td>:</td>
					<td><input name="noOfLeaveEntitlement" id="noOfLeaveEntitlement" value="<%= leave.getDays() %>"></input>
						<input name="leave_entitlement_id" id="leave_entitlement_id" type="hidden" value="<%= leave.getLeaveEntitlementId() %>"></input>
					</td>
				</tr>
				
				<tr>
					<td></td>
					<td></td>
					<td>
						<br/>
						<button type="submit" value="update">Update</button>&emsp;
						<button type="button" value="cancel" id="cancelUpdate" onclick="goBack()">Cancel</button>
					</td>
				</tr>
		</tbody>		
			</table>  
				
</form>
        </div>

    </div>

    <hr />

    <div id="footer">

        <p>Copyright &#169; 2016 pactera.com. All rights reserved.</p>

    </div>

</div>



</body>



</html>