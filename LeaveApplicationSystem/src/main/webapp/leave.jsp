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
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">

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

	function validateForm() {
	    var a = document.forms["leaveform"]["date"].value;  
	    var b = document.forms["leaveform"]["date"].value;
	    var c = document.forms["leaveform"]["from"].value;
	    var d = document.forms["leaveform"]["to"].value;
	    var e = document.forms["leaveform"]["reason"].value;
	    if (a == null || a == "") {
	        alert("Date must be filled in..");
	        return false;
	    }
	    if( b == null || b == "" ){
	    	alert("'Leave from' must be filled in..");
	        return false;
	    }
	    if( c == null || c == "" ){
	    	alert("'Leave to' must be filled in..");
	        return false;
	    }
	    if( d == null || d == "" ){
	    	alert("Reason must be filled in..");
	        return false;
	    }
	    
	    var e = document.getElementById('type').value;
	    if(e == null || e == ""){
	    	alert("Please Select Leave Type");
	    	return false;
	    }
	    var f = document.getElementById('dur').value;
	    if(f == null || f == ""){
	    	alert("Please Select Leave duration");
	    	return false;
	    }
	    var g = document.getElementById('status').value;
	    if(g == null || g == ""){
	    	alert("Please Select Leave status");
	    	return false;
	    }
	    if(a != c){
	    	alert("From date should be same as leave date");
	    	return false;
	    }
	    if(c>d){
	    	alert("From date should be before to date");
	    	return false;
	    }
	}
	
	
	
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

            <h2>Leave Information</h2>

            <form name = "leaveform" method="post" action="leave.do" " onsubmit = "return validateForm()">

                 <table>

                        <tbody>

                        <tr>

                            <td><label for="leavetype" name="type" value = "please select">Leave Type</label></td>

                            
                            <td><select name="type" id = "type">
                            <option value = "" >Please Select </option>
                            <option value = "1" >AL </option>
                            <option value = "2"  >MC </option>
                            <option value = "3"  >EL </option>
                            </select></td>

                        </tr>

                        <tr>

                            <td><label for="frwd">Forward Application to</label></td>

                            <td><input type="text" name="frwd" id="frwd" value = "Rickey Teoh" readonly/></td>
                                                                       
							
                        </tr>  
                        
                        <tr>

                            <td><label for="duration" >Leave Duration</label></td>

                            <td><select name = "dur" id="dur" >
                            <option value = "0" >Please Select  </option>
                            <option value="halfday" >Full Day</option>
                            <option value="fullday" >Half Day</option>
                            <option value="2 days" >2 Days</option>
                            <option value="3 days" >2 Days</option>
                            <option value="4 days" >2 Days</option>
                            <option value="5 days" >2 Days</option>
                            <option value="6 days" >2 Days</option>
                            <option value="7 days" >2 Days</option>
                            <option value="8 days" >2 Days</option>
                            <option value="9 days" >2 Days</option>
                            <option value="10 days" >2 Days</option>
                            
                            </select></td>
                            
							
                        </tr>
                        
                        <tr>

                            <td><label for="date">Leave Date</label></td>

                            <td><input type="text" name="date" id="datepicker" /></td>
							
                        </tr> 
                        
                        <tr>

                            <td><label for="period" >Leave Period</label></td>

                            <td><input type="radio" name="period" id="period" value = "AM" />AM 
                                <input type="radio" name="period" id="period" value = "PM" />PM</td>
							
                        </tr> 
                       
                        <tr>

                            <td><label for="from">Leave From</label></td>

                            <td><input type="text" name="from" id="datepicker1" /></td>
							
                        </tr> 
                        
                        <tr>

                            <td><label for="to">Leave To</label></td>

                            <td><input type="text" name="to" id="datepicker2" /></td>
							
                        </tr>   
                        
                         
                        <tr>

                            <td><label for="reason">Reason</label></td>

                            <td><input type="text" name="reason" id="reason" /></td>
							
                        </tr> 
                        
                        <tr>

                            <td><label for="status">Approval Status</label></td>

                            <td><select name = "status" id ="status" >
                            <option value = "0" >Please Select  </option>
                            <option value="Applied" >Applied </option>
                            <option value="Approved" >Approved </option>
                            <option value="Rejected" >Rejected </option>
                            
                            </select></td>
							
                        </tr> 
                        

                        </tbody>

                    </table>

                    <p class="centered"><input type="submit" value="Submit" onclick="Validate()"/> <input type="button" value="Clear" onclick="window.location.href = window.location.href" /></p>

                </div>
                <div id="footer">

        			<p>Copyright &#169; 2016 pactera.com. All rights reserved.</p>
			
				</div>
                

            </form>

        </div>

    </div>

    <hr />

</div>



</body>



</html>

