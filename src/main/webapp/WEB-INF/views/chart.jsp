<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=iso-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader( "Pragma", "no-cache" );
response.setHeader( "Cache-Control", "no-cache" );
response.setDateHeader( "Expires", 0 ); 
  
%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title><c:out value="${stockSymbol}" /> Chart Details</title>
<link rel="stylesheet" type="text/css" href="css/tabs.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script src="js/highstock.js"></script>
<script src="js/exporting.js"></script>
		
		<script type="text/javascript" src="js/jquery.datepick.js"></script>
					<link type="text/css" rel="stylesheet" href="css/jquery.datepick.css" />
		<script type="text/javascript" src="js/chart.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />
		<script type="text/javascript" src="js/jquery.alerts.js"></script>
    <script type = "text/javascript" >
       function preventBack(){window.history.forward();}
        setTimeout("preventBack()", 10);
        window.onunload=function(){null};
    </script>
		<link rel="stylesheet" type="text/css" href="css/tabs.css" />
		<style type="text/css">
.center {
	margin: auto;
	width: 982px;
	height: auto;
	border: thick;
	background-color: #212a3e;
}
/* Custom dialog styles */
			#popup_container.style_1 {
				font-family: Georgia, serif;
				color: #A4C6E2;
				background: #005294;
				border-color: #113F66;
			}
			
			#popup_container.style_1 #popup_title {
				color: #FFF;
				font-weight: normal;
				text-align: left;
				background: #76A5CC;
				border: solid 1px #005294;
				padding-left: 1em;
			}
			
			#popup_container.style_1 #popup_content {
				background: none;
			}
			
			#popup_container.style_1 #popup_message {
				padding-left: 0em;
			}
			
			#popup_container.style_1 INPUT[type='button'] {
				border: outset 2px #76A5CC;
				color: #A4C6E2;
				background: #3778AE;
			}
#contentReg {
	background:white;
	padding: 2em;
	height: 500px;
	position: relative;
	z-index: 2;
	border-radius: 0 5px 5px 5px;
	box-shadow: 0 -2px 3px -2px rgba(0, 0, 0, .5);
}
</style>
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



	<script type="text/javascript">
<!--
function print_today() {
  var now = new Date();
  var months = new Array('01','02','03','04','05','06','07','08','09','10','11','12');
  var date = ((now.getDate()<10) ? "0" : "")+ now.getDate();
  
  var today =  now.getFullYear()+'-'+months[now.getMonth()] + "-" +date;
  return today;
}
var stockId= <c:out value="${stockID}" />;
	 var stockSymbol = '<c:out value="${stockSymbol}" />';

	$(document).ready(function() {
$('#d').datepick({dateFormat: 'yyyy-mm-dd'});
  loadLiveChart(stockId,stockSymbol);
   getChartDetails(stockId,stockSymbol);
   $('#getchart').click(function (){
            var dt = $('#d').val();
			if (dt ==''){
			var curDt =print_today();
			
			   jAlert('Please enter date: ', 'Input Error');
			}else if (( new Date(dt).getTime()) > (new Date(print_today()).getTime())){
			 jAlert('Please enter privious date: from '+print_today(), 'Input Error');
			}else if(new Date(dt).getFullYear()!=(new Date(print_today()).getFullYear())){
			 jAlert('Please enter current year date:', 'Input Error');
			}else{
			   dayChart(dt,stockId,stockSymbol);
			}
   });
    $("#contentReg div").hide(); // Initially hide all content
    $("#tabs li:first").attr("id","current"); // Activate first tab
    $("#contentReg div:first").fadeIn(); // Show first tab content
     $('#tabs a').click(function(e) {
        e.preventDefault();
        if ($(this).closest("li").attr("id") == "current"){ //detection for current tab
         return       
        }
        else{             
        $("#contentReg div").hide(); //Hide all content
        $("#tabs li").attr("id",""); //Reset id's
        $(this).parent().attr("id","current"); // Activate this
        $('#' + $(this).attr('name')).fadeIn(); // Show content for current tab
		  $('#container').css('display','block');
		 $('#cmenu').css('display','block');
		  $('#container2').css('display','block');
		   $('#container3').css('display','block');
		   getChartDetails(stockId,stockSymbol);
		   loadLiveChart(stockId,stockSymbol);
        }
      
    });
	

	  $('#container').css('display','block');
		 $('#cmenu').css('display','block');
		  $('#container2').css('display','block');
		   $('#container3').css('display','block');
$("#themes").change(function() {
    var selecetdVal = $(this).find("option:selected").val();
	
	changeTheme(selecetdVal);
	
	
    
});

   });

//-->
</script>
	</head>
	<body>
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
					<li><a href="#" name="tab1">Yearly Stock Chart</a></li>
					<li><a href="#" name="tab2">Live Stock Chart</a></li>
	                <li><a href="#" name="tab3">Day Stock Chart</a></li>
				</ul>
               
				<div id="contentReg">
					<div id="tab1">
					 <div style="width:100%;height:20px" id="cmenu">
					   <span >Chart Themes</span>
					     <select id="themes">
                           <option value="js/charttheme/default.js" selected="selected">Defalut</option>
						   <option value="js/charttheme/dark-green.js" >Green</option>
						   <option value="js/charttheme/dark-blue.js" >Dark Blue</option>
    				       <option value="js/charttheme/gray.js" >Gray</option>
						   <option value="js/charttheme/grid.js">Grid</option>
                         </select>
                       
				

				   
				</div><hr/>
						<div id="container" style="height: 100%;width:100%">
						</div>
					</div>
					<div id="tab2">
						<div id="container2" style="height: 100%;width:100%">
						
						</div>
					</div>
					<div id="tab3">
					Enter the date :
					 <input type="text" id="d"/> <input type="button" value="Get Chart"  id="getchart"/>
						<div id="container3" style="height: 100%;width:100%">
						  
						</div>
					</div>
						<a href="welcome.do" >Back to stock list</a>

				</div>
					
				</div>
			</div>
			<footer> @Copyright:stock -moneytracker.com @All right
				reserved </footer>

		</div>
	
	</body>
</html>

