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
            <h2>Login</h2>
            <form method="post" action="login.do" onsubmit="">
                <div class="centered">
                    <table>
                        <tbody>
                        <tr>
                            <td><label for="user">Username</label></td>
                            <td><input type="text" name="user" id="user" maxlength="50" value="" required /></td>
                        </tr>
                        <tr>
                            <td><label for="pass">Password</label></td>
                            <td><input type="password" name="pass" id="pass"  required/></td>
                        </tr>
                        </tbody>
                    </table>
                    <p class="centered"><input type="submit" value="Submit" /> <input type="button" value="Clear" onclick="window.location.href = window.location.href" /></p>
                </div>
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
