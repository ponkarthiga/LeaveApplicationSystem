<%@ page import="com.pactera.bean.*,com.pactera.dao.*,java.util.List" %>
<?xml version="1.0" encoding="utf-8"?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html lang="en-us" xml:lang="en-us" xmlns="http://www.w3.org/1999/xhtml">



<head>

<style type="text/css" media="screen" xml:space="preserve">
/*<![CDATA[*/
@import url("css/default.css");
/*]]>*/
</style>

<link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css" />
	<script src="http://www.google.com/jsapi"></script>  
	<script>  
		google.load("jquery", "1");
	</script>
	<script src="js/jquery.autocomplete.js"></script>  
	<script src="http://www.google.com/jsapi"></script>  
	<script>  
		google.load("jquery", "1");
	</script>
	<script src="js/jquery.autocomplete.js"></script>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta http-equiv="Content-Language" content="en-us" />

<title>Leave Application System</title>

<meta name="Author" content="" />

<meta name="Description" content="Leave Application System" />

<meta name="Keywords" content="pactera" />
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
	List<UserBean> user = (List<UserBean>)request.getAttribute("listOfEmployee");
	List<ParameterBean> param = (List<ParameterBean>)request.getAttribute("listOfParam");
	
	String empId = (String)request.getAttribute("empId");
	String empName = (String)request.getAttribute("empName");
%>
 		<h2>Report Filters</h2>
		<br></br>
		<form method="post" action="reports.do">
		<table>
			<tr>
				<td>
					By Employee Id
				</td>
				<td>:</td>
				<td>
					<input name="empId" id="empId" type="text" <%if(empId != null){%>value="<%= empId%>"<%}else{%>value=""<%} %>/>
					<script>
						$("#empId").autocomplete("getdata.jsp");
					</script>
				</td>
				<td>eg.P0001</td>
			</tr>
			<tr>
				<td>
					By Employee Name
				</td>
				<td>:</td>
				<td>
					<input name="empName" id="empName" 
					
						<%if(empName != null){%>
							value="<%= empName%>"<%
						}else{
							%>value=""<%
						}%>/>
				</td>
				<td>eg.Adzam</td>
			</tr>
			<tr>
				<td>
					By Employee Department
				</td>
				<td>:</td>
				<td>
					<select name="empDepartment" id="empDepartment">
						<option value="">Please Select</option>
						<% for(ParameterBean list : param){ 
									if(list.getParameterType().equals("Department")){%>
									<option value="<%= list.getParameterCode()%>"><%= list.getParameterCode()%></option>
								<% }}%>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>
					By Leave Type
				</td>
				<td>:</td>
				<td>
					<select name="leaveType" id="leaveType">
						<option value="">Please Select</option>
						<% for(ParameterBean list : param){ 
									if(list.getParameterType().equals("Leave Type")){%>
									<option value="<%= list.getParameterCode()%>"><%= list.getParameterCode()%></option>
								<% }}%>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>
					By Employee Status
				</td>
				<td>:</td>
				<td>
					<select name="empStatus" id="empStatus">
						<option value="">Please Select</option>
						<option value="Active">Active</option>
						<option value="Resigned">Resigned</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>
					By Application Status
				</td>
				<td>:</td>
				<td><select name="appStatus" id="appStatus">
						<option value="">Please Select</option>
						<option value="Approve">Approved</option>
						<option value="Reject">Rejected</option>
						<option value="Pending Approval">Pending Approval</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>
					From Date
				</td>
				<td>:</td>
				<td><input name="fromDate" id="fromDate" value=""></input></td>
			</tr>
			
			<tr>
				<td>
					For Date
				</td>
				<td>:</td>
				<td><input name="forDate" id="forDate" value=""></input></td>
				<td><button type="submit">Search</button></td>
			</tr>
			
		</table>
		
		</form>
		<br/>
			<table width="100%">
				<tr bgcolor="blue" style="color:white">
					<th>Employee ID</th>
					<th>Employee Name</th>
					<th>Leave Type</th>
					<th>Department</th>
					<th>Leave From</th>
					<th>Leave To</th>
					<th>Days</th>
					<th>Approval Status</th>
				</tr>
				
				<%for (UserBean  searchUser: user){ %>
				<tr>
					<td><%= searchUser.getEmpId() %></td>
					<td><%= searchUser.getEmpName() %></td>
					<td></td>
					<td><%= searchUser.getEmpDepartment() %></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<%} %>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td colspan="2" align="right">
						<form action ="reports.do">
    						<button><a href="reports.do?clicked=0&empId<%= empId%>&empName=<%= empName%>">Export to Excel</a></button>
 						</form>
					</td>
				</tr>
		</table>
        </div>

    </div>

    <div id="footer">

        <p>Copyright &#169; 2016 pactera.com. All rights reserved.</p>

    </div>

</div>



</body>



</html>