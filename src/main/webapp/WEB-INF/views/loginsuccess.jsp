<%@ page language="java" contentType="text/html; charset=iso-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader( "Pragma", "no-cache" );
response.setHeader( "Cache-Control", "no-cache" );
response.setDateHeader( "Expires", 0 ); 
  
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>www.moneytracker.com</title>

<style type="text/css" >
.center {
	margin: auto;
	width: 982px;
	height: auto;
	border: thick;
	background-color:black;
}
</style>
<link rel="stylesheet" type="text/css" href="css/tabs.css" />


<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/jquery.datepick.css" />
<script type="text/javascript" src="js/jquery.datepick.js"></script>
<script type="text/javascript" src="js/jquery.tablescroll.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery.alerts.js"></script>
<script type="text/javascript" src="js/investerFunction.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.tablescroll.css" />
<script type="text/javascript" src="js/jquery.blockUI.js"></script>
    <script type = "text/javascript" >
       function preventBack(){window.history.forward();}
        setTimeout("preventBack()", 10);
        window.onunload=function(){null};
    </script>
<script>

$(document).ready(function() {



    $("#content div").hide(); // Initially hide all content
    $("#tabs li:first").attr("id","current"); // Activate first tab
    $("#content div:first").fadeIn(); // Show first tab content
     $('#tabs a').click(function(e) {
        e.preventDefault();
        if ($(this).closest("li").attr("id") == "current"){ //detection for current tab
		
         return       
        }
        else{      
		    loadStock();
			editStock();
        $("#content div").hide(); //Hide all content
        $("#tabs li").attr("id",""); //Reset id's
        $(this).parent().attr("id","current"); // Activate this
        $('#' + $(this).attr('name')).fadeIn(); // Show content for current tab
		$('.tablescroll').css('display','block');
        $('.tablescroll_wrapper').css('display','block');
		     $('#tab22').css('display','block');
		
	   document.getElementById('tab22').innerHTML='';
		
        }
     // loadStock();
    });
	
	$('#thetable').tableScroll({height:150});
	//$('#thetable2').tableScroll({height:100});
	$('#thetable3').tableScroll({height:100});
$('.tablescroll_head').css('width','100%');
$('.tablescroll_wrapper').css('width','100%');
$('#thetable').css('width','100%');
//$('#thetable2').css('width','100%');
$('#thetable3').css('width','100%');
loadStock();
			editStock();
setInterval(function() {
    loadStock();
}, 300000);


});
function datePicker(id){
 $('#'+id).datepick({dateFormat: 'yyyy-mm-dd'});
}




</script>

<style type="text/css">
<!--
body {
	background-color: #c9c7ca;
}

body,td,th {
	color: #0099FF;
	font-family: Times New Roman, Times, serif;
	font-weight: bold;
}
</style>
</head>

<body>
	<label id="txt"></label>
	<div class="center">
		<div style="width: 100%; height: 80px">
			<label id="uname">Welcome :<c:out
					value="${invster.firstName}" /></label> <a href="logout.do"
				style="color: #FFFFFF">Log out</a> &nbsp;&nbsp;<a href="profile.do"
				style="color: #FFFFFF">My Profile</a>
		</div>

		<div style="width: 100%; height: 251px; margin-top: -6%">
			<img src="images/page-banner-investments.jpg" width="100%"
				height="100%" />

		</div>

		<div id="midd"
			style="background-color: #232323; width: 100%; height: auto;">
			<div id="menuActive" style="width: 100%; margin-top: -5%;">
				<ul id="tabs">

					<li><a href="#" name="tab1">My Portfolio</a></li>
					<li><a href="#" name="tab2">Add Stock</a></li>
			         <li><a href="#" name="tab3">Edit Stocks</a></li>

				</ul>

				<div id="content">
					<div id="tab1">
					<span dir="rtl">
                  <a id="ecsv" href="getStockCSV.do?time=1"><img src="images/csv_text.png" title="Export CSV file" style="width:32px;height:32px" /></a></span>
				 
						<label>Stock List</label><br />
						<hr>
						<table id="thetable" cellspacing="0">


						</table>


					</div>

					<div id="tab2">
						<label>Add Stock to portfolio </label><br />
						<hr>
						<input id="addstock" type="text" size="70" maxlength="10"
							placeholder="Please Enter stock symbol or company name">
						<input type="submit"  value="Search For Stock" onClick="searchStock()" />
						<div id="tab22" style="width:100%;height:190px;">
						
						</div>

					</div>
					<div id="tab3">
					<table id="thetable3" cellspacing="0" >


						</table>
					</div>

				</div>
			</div>
		</div>
		<div style="display: none;">
			<div id="logindiv"
				style="width: 400px; height: 100px; overflow: hidden;">You div
				with login data and input fields</div>
		</div>


		<footer> &copy;Stock -moneytracker.com @All right
			reserved </footer>
	</div>
</body>
</html>
