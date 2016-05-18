<%@ page import="com.pactera.bean.*, java.util.*"%>

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

</head>

<body>

	<div id="wrapper">

		<div id="header">

			<h1>Pactera : Leave Application System</h1>

		</div>

		<div id="page-body">

			<%@ include file="links.jsp"%>

			<div id="content">

				<%
					List<LeaveBean> listOfLeaves = (List<LeaveBean>) request.getAttribute("leaves");
					listOfLeaves = (listOfLeaves == null) ? new Vector<LeaveBean>() : listOfLeaves;
				%>
				<h2>Leave List Page</h2>
				
				<form method="get" action="leavelist.do">
				
					<table style="width:100%" border="1">
						<thead>
							<tr bgcolor="blue">
								<th>Id</th>
								<th>Leave Type</th>
								<th>Leave From</th>
								<th>Leave To</th>
								<th>Reason</th>
								<th>Date Created</th>
								<th>Date Updated</th>
<!-- 								<th>Action</th> -->
								<th>Approval Status</th>
								<th>Action</th>
								
							</tr>
						</thead>
						<tbody>
							<%
								for (LeaveBean leaves : listOfLeaves) {
							%>
							<tr>
								<td><%=leaves.getLeaveId()%></td>
								<td><%=leaves.getLeaveType()%></td>

								<td><%=leaves.getLeaveFrom()%></td>
								<td><%=leaves.getLeaveTo()%></td>
								<td><%=leaves.getLeaveReason()%></td>
								<td><%=leaves.getDateCreated()%></td>
								<td><%=leaves.getDateUpdated()%></td>

<!-- 								<td><select name="Action"> -->
<!-- 										<option value="Approve"></option> -->
<!-- 										<option value="Reject"></option> -->
<!-- 								</select></td> -->

								<td><%=leaves.getApprovalStatus()%></td>
								<td><a
									href="updleave.do?leave_id=<%=leaves.getLeaveId()%>&step=edit">Edit</a>
								<a
									href="updleave.do?leave_id=<%=leaves.getLeaveId()%>&step=0">Delete</a></td>

							</tr>
							<%
								}
							%>
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