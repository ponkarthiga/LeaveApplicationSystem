<%@ page import="com.pactera.bean.*" %>

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

<%@ include file="links.jsp" %>

        <div id="content">

<%
UserBean userB = (UserBean) request.getAttribute("userA");
userB = (null == userB) ? (new UserBean()) : userB;
%>
            <h2>Profile</h2>
<form method="post" action="profile.do">
          	<table>
          		<tbody>
          			<tr>
          				<td>ID</td>
          				<td><input type="text" name="userId" value="<%=userB.getUserId() %>"/></td>
          			</tr>
          			<tr>
          				<td>Name</td>
          				<td><%=userB.getUserName() %></td>
          			</tr>
          			<tr>
          				<td>First Name</td>
          				<td><input type="text" name="firstName" value="<%=userB.getFname() %>"/></td>
          			</tr>
          			<tr>
          				<td>Middle Name</td>
          				<td><%=userB.getMname() %></td>
          			</tr>
          			<tr>
          				<td>Last Name</td>
          				<td><%=userB.getLname() %></td>
          			</tr>
          			<tr>
          				<td><input type="submit" value="Update" /></td>
          				<td></td>
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

