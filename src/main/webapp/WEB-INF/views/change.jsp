<%@ page language="java" contentType="text/html; charset=iso-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader( "Pragma", "no-cache" );
response.setHeader( "Cache-Control", "no-cache" );
response.setDateHeader( "Expires", 0 ); 
  if(request.getSession().getAttribute("invster") ==null){
     response.sendRedirect("index.jsp");
  }
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>www.moneytracker.com</title>

<style type="text/css">
.center {
	margin: auto;
	width: 982px;
	height: auto;
	border: thick;
	
}

#contentReg {
	background: white;
	padding: 2em;
	height: 500px;
	position: relative;
	z-index: 2;
	border-radius: 0 5px 5px 5px;
	box-shadow: 0 -2px 3px -2px rgba(0, 0, 0, .5);
}
</style>
<link rel="stylesheet" type="text/css" href="css/tabs.css" />
</script>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>

<script type="text/javascript" src="js/jquery.alerts.js"></script>

<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />





<script>
$(document).ready(function() {

   $(".buttons").click(function() 
{
var id = $(this).attr("id");
if(id=='step1')
{
   var password = $('#password').val();
	if (password==null || password==""){
	   jAlert('Please input password ', 'Required');	
	}else if (password.length<5){
	   jAlert('password length must be greater than 5 character ', 'Required');	
	}else{
	$("#step1").remove();
$.ajax({
        url: 'changepassword.do',
        type: 'post',
        data: $('form#changepassword').serialize(),
        success: function(data) {
        	var msg='';
        	if(data=='fail'){
        		msg = 'Server problem'
        	}else{
        		msg = 'Your password hase been set please \n<a href="login.do">Click Here to Login</a>';
        	}
        	
        	$("#step2").remove();
        	$("#tab1").slideUp('slow',function() {$("#tab1").remove();});
        	$("#thank").html(msg);
        	
        }
    });

	}
}



return false;
});
	

	
});
</script>

<style type="text/css">
<!--
body {
	background-color: #999999;
}

body,td,th {
	color: #0099FF;
	font-family: Times New Roman, Times, serif;
	font-weight: bold;
}
</style>
<style>
#box1 {
	width: 100%;
	height: 220px;
	background-color: #FFFFFF;
}

#box2 {
	display: none;
	width: 100%;
	height: 220px;
	background-color: #FFFFFF;
}

#box3 {
	display: none;
	width: 100%;
	height: 220px;
	background-color: #FFFFFF;
}

#step2 {
	display: none;
}

#step3 {
	display: none;
}
</style>

</head>

<body>
	<div class="center">

		<div style="width: 100%; height: 251px; margin-top: -6%">
			<img src="images/page-banner-investments.jpg" width="100%"
				height="100%" />
		</div>
		<div id="midd"
			style="background-color: #232323; width: 100%; height: auto;">
			<div id="menuActive" style="width: 100%; margin-top: -5%;">
				<ul id="tabs">
					<li><a href="#" name="tab1">Money Tracker Investor  Change Password Form</a></li>

				</ul>

				<div id="contentReg">
					<div id="tab1">
						<form  id="changepassword">

							<div id="box1">
								<fieldset>
									<legend>Change Password</legend>
                                     <input type="password" id="password" name="password" placeholder="Enter new password" />
							  </fieldset>
							</div>
							<input type="submit" class="buttons" id="step1"
								value=" Registration " />


						</form>

					</div>
					<div id="thank"></div>
				</div>
			</div>
			<footer> @Copyright:stock -moneytracker.com @All right
				reserved </footer>

		</div>
</body>
</html>
