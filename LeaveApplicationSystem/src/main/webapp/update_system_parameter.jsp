<%@ page import="com.pactera.bean.*, com.pactera.dao.*" %>
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
        location.href = "system_parameter.do";
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
ParameterBean param = (ParameterBean) request.getAttribute("paramBean");
param = (null == param) ? (new ParameterBean()) : param;
%>
            <h2>Update System Parameter</h2>
            
            <form method="post" action="update_system_parameter.do">
<table>
<tbody>
				<tr>
					<td>Parameter Type</td>
					<td>:</td>
					<td><%= param.getParameterType() %>
						<input name="parameterType" id="paramType" value="<%= param.getParameterType() %>" type="hidden"></input>
					</td>
				</tr>
				
				<tr>
					<td>Parameter Code</td>
					<td>:</td>
					<td><input name="parameterCode" id="parameterCode" value="<%= param.getParameterCode() %>"></input></td>
				</tr>
				
				<tr>
					<td>Description</td>
					<td>:</td>
					
					<td><input name="parameterDescription" id="parameterDescription" value="<%= param.getDesc() %>"></input>
						<input name="parameter_id" id="parameter_id" type="hidden" value="<%= param.getParameterId() %>"></input>
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