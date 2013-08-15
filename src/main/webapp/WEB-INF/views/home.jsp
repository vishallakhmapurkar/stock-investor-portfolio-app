
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>www.moneytracker.com</title>
<LINK REL="SHORTCUT ICON" HREF="favicon.ico">
<style type="text/css">
.center {
	margin: auto;
	width: 982px;
	height: auto;
	border: thick;
	background-color: #212a3e;
}

#login {
	background-color: #fff;
	background-image: -webkit-gradient(linear, left top, left bottom, from(#fff),
		to(#eee) );
	background-image: -webkit-linear-gradient(top, #fff, #eee);
	background-image: -moz-linear-gradient(top, #fff, #eee);
	background-image: -ms-linear-gradient(top, #fff, #eee);
	background-image: -o-linear-gradient(top, #fff, #eee);
	background-image: linear-gradient(top, #fff, #eee);
	height: 200px;
	width: 430px;
	position: relative;
	z-index: 0;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	-webkit-box-shadow: 0 0 2px rgba(0, 0, 0, 0.2), 0 1px 1px
		rgba(0, 0, 0, .2), 0 3px 0 #fff, 0 4px 0 rgba(0, 0, 0, .2), 0 6px 0
		#fff, 0 7px 0 rgba(0, 0, 0, .2);
	-moz-box-shadow: 0 0 2px rgba(0, 0, 0, 0.2), 1px 1px 0 rgba(0, 0, 0, .1),
		3px 3px 0 rgba(255, 255, 255, 1), 4px 4px 0 rgba(0, 0, 0, .1), 6px 6px
		0 rgba(255, 255, 255, 1), 7px 7px 0 rgba(0, 0, 0, .1);
	box-shadow: 0 0 2px rgba(0, 0, 0, 0.2), 0 1px 1px rgba(0, 0, 0, .2), 0
		3px 0 #fff, 0 4px 0 rgba(0, 0, 0, .2), 0 6px 0 #fff, 0 7px 0
		rgba(0, 0, 0, .2);
}

#login:before {
	content: '';
	position: absolute;
	z-index: -1;
	border: 1px dashed #ccc;
	-moz-box-shadow: 0 0 0 1px #fff;
	-webkit-box-shadow: 0 0 0 1px #fff;
	box-shadow: 0 0 0 1px #fff;
}

#inputs input {
	background: #f1f1f1
		url(http://www.red-team-design.com/wp-content/uploads/2011/09/login-sprite.png)
		no-repeat;
	padding: 15px 15px 15px 30px;
	margin: 0 0 10px 0;
	width: 353px; /* 353 + 2 + 45 = 400 */
	border: 1px solid #ccc;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	-moz-box-shadow: 0 1px 1px #ccc inset, 0 1px 0 #fff;
	-webkit-box-shadow: 0 1px 1px #ccc inset, 0 1px 0 #fff;
	box-shadow: 0 1px 1px #ccc inset, 0 1px 0 #fff;
}

#username {
	background-position: 5px -2px !important;
}

#password {
	background-position: 5px -52px !important;
}

#inputs input:focus {
	background-color: #fff;
	border-color: #e8c291;
	outline: none;
	-moz-box-shadow: 0 0 0 1px #e8c291 inset;
	-webkit-box-shadow: 0 0 0 1px #e8c291 inset;
	box-shadow: 0 0 0 1px #e8c291 inset;
}

/*--------------------*/
#actions {
	margin: 15px 0 0 0;
}

#actions a {
	color: #3151A2;
	float: right;
	line-height: 35px;
	margin-left: 10px;
}
</style>
<link rel="stylesheet" type="text/css" href="css/tabs.css" />
<link rel="stylesheet" type="text/css" href="css/home.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.validate.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>

<script src="js/jquery.validate.js" type="text/javascript">
 </script>
<script src="js/jquery.validation.functions.js" type="text/javascript">
 </script>

<script type="text/javascript" src="js/wowslider.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/like.js"></script>
<script type="text/javascript" src="js/jquery.alerts.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />
<link rel="stylesheet" type="text/css" media="all"
	href="css/jquery.fancybox.css">
<script type="text/javascript" src="js/jquery.fancybox.js?v=2.0.6"></script>
<script type="text/javascript" src="js/contactform.js"></script>
<script type="text/javascript" src="js/jquery.blockUI.js"></script>
    <script type = "text/javascript" >
       function preventBack(){window.history.forward();}
        setTimeout("preventBack()", 10);
        window.onunload=function(){null};
    </script>
<script>

 jQuery(function(){
  jQuery.ajaxSetup({
  beforeSend: function() {
    $.blockUI({ css: { 
            border: 'none', 
            padding: '15px', 
            backgroundColor: '#000', 
            '-webkit-border-radius': '10px', 
            '-moz-border-radius': '10px', 
            opacity: .5, 
            color: '#fff' 
        } }); 
  },
  complete: function(){
    $.unblockUI()
  }
});
loadDoc();
contactUs();
                jQuery("#username").validate({
                    expression: "if (VAL) return true; else return false;",
                    message: "Please enter the Required field"
                });
				jQuery("#password").validate({
                    expression: "if (VAL.length > 5 && VAL) return true; else return false;",
                    message: "Please enter a valid Password"
                });
				jQuery('.loginForm').validated(function(){
					document.forms["loginForm"].submit();
				});
				
	});
	
	function loadDoc(){
	$('#btnSubmit').click(function(){
   forgetPassword();
});
    $("#content div").hide(); // Initially hide all content
    $("#tabs li:first").attr("id","current"); // Activate first tab
    $("#content div:first").fadeIn(); // Show first tab content
    $("#wowslider-container1").css("display","block");
	$(".ws_images").css("display","block");;
	$(".ws_bullets").css("display","block");


    $('#tabs a').click(function(e) {
        e.preventDefault();
        if ($(this).closest("li").attr("id") == "current"){ //detection for current tab
         return       
        }
        else{             
        $("#content div").hide(); //Hide all content
        $("#tabs li").attr("id",""); //Reset id's
        $(this).parent().attr("id","current"); // Activate this
        $('#' + $(this).attr('name')).fadeIn(); // Show content for current tab
		 $("#wowslider-container1").css("display","block");
	$(".ws_images").css("display","block");;
	$(".ws_bullets").css("display","block");;
	
		
		$("#lc").css("display","block");;
		$("#ll").css("display","block");;
		$("#lr").css("display","block");;
		$("#contactus").css("display","block");;
			$("#clink").css("display","block");
	$("#cimg").css("display","block");
        }
    });
	

            $("#fp").click(function (e)
            {
                ShowDialog(false);
                e.preventDefault();
            });

           

            $("#btnClose").click(function (e)
            {
                HideDialog();
                e.preventDefault();
            });

            $("#btnSubmit").click(function (e)
            {
                var brand = $("#brands input:radio:checked").val();
                $("#output").html("<b>Your favorite mobile brand: </b>" + brand);
                HideDialog();
                e.preventDefault();
            });

	}			

</script>
<style type="text/css">
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
</head>

<body>
	<div id="overlay" class="web_dialog_overlay" style="display: none;"></div>

	<div id="dialog" class="web_dialog" style="display: none;">
		<table style="width: 100%; border: 0px;" cellpadding="3"
			cellspacing="0">
			<tbody>
				<tr>
					<td class="web_dialog_title">Forget Password</td>
					<td class="web_dialog_title align_right"><a href="#"
						id="btnClose">Close</a></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" style="padding-left: 15px;"><input type="text"
						id="femail" placeholder="Enter your email id" /></td>
				</tr>

				<tr>
					<td colspan="2" style="text-align: center;"><input
						id="btnSubmit" type="button" value="Get password"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="center">

		<div style="width: 100%; height: 251px; margin-top: -6%">
			<img src="images/page-banner-investments.jpg" width="100%"
				height="100%" />
		</div>
		<div id="midd"
			style="background-color: #232323; width: 100%; height: auto;">
			<div id="menuActive" style="width: 100%; margin-top: -5%;">
				<ul id="tabs">
					<li><a href="#" name="tab1">Home</a></li>
					<li><a href="#" name="tab2">About Us</a></li>
					<li><a href="#" name="tab3">Contact Us</a></li>
				</ul>

				<div id="content">
					<div id="tab1">

						<table width="100%" height="100%" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td width="50%">
									<form id="login" action="login.do" method="post" class="loginForm"
										name="loginForm">

										<fieldset id="inputs">
											<input id="username" name="username" type="text"
												placeholder="Username" autofocus required> <input
												id="password" name="password" type="password"
												placeholder="Password" required>
										</fieldset>
										<fieldset id="actions">
											<input type="submit" id="submit" value="Log in"> <a
												href="#" id="fp">Forgot your password?</a><a href="register.do">Register</a>
										</fieldset>

									</form>
									<br>
									${error}
								</td>
								<td width="50%"><label>Chart Snapshots provided by us:</label>
									<div id="wowslider-container1">
										<div class="ws_images">
											<ul>
												<li><img src="images/chart.jpg" alt="chart"
													title="chart" id="wows1_0" /></li>
												<li><img src="images/chart_1.jpg" alt="chart (1)"
													title="chart (1)" id="wows1_1" /></li>
												<li><img src="images/chart_2.jpg" alt="chart (2)"
													title="chart (2)" id="wows1_2" /></li>
												<li><img src="images/chart_3.jpg" alt="chart (3)"
													title="chart (3)" id="wows1_3" /></li>
												<li><img src="images/chart_4.jpg" alt="chart (4)"
													title="chart (4)" id="wows1_4" /></li>
											</ul>
										</div>
										<div class="ws_bullets">
											<div>
												<a href="#" title="chart"><img
													src="images/tooltips/chart.jpg" alt="chart" />1</a> <a href="#"
													title="chart (1)"><img
													src="images/tooltips/chart_1.jpg" alt="chart (1)" />2</a> <a
													href="#" title="chart (2)"><img
													src="images/tooltips/chart_2.jpg" alt="chart (2)" />3</a> <a
													href="#" title="chart (3)"><img
													src="images/tooltips/chart_3.jpg" alt="chart (3)" />4</a> <a
													href="#" title="chart (4)"><img
													src="images/tooltips/chart_4.jpg" alt="chart (4)" />5</a>
											</div>
										</div>
										</div>
										</td>
										
							</tr>
						</table>
					

					</div>

					<div id="tab2">
						<b>About Us</b>
						<br> 
						<p style="color:#999999">The foundation on which moneytracker.com is built is best summarized by a quote from Vishal Lakhmapurkar<br> </p>
						<b>Our Vision</b>
						<br> 
						<p style="color:#999999">
						"Swim in a stream that becomes a
						river and ultimately an ocean. Be a leader in that market, not a
						follower, and constantly build the best products possible."
						<br>
						 We can
						gives our customer to track their stocks and maintain them. We
						gives them alerts about their stock prices within some interval
						decided by them. Over all our policy to make a good relationship
						with investers and kepp this longer.</p>
					</div>
					<div id="tab3">
						<div style="width: 100%; float: left" id="contactus">
							<div style="width: 50%; float: left; display: block" id="clink">
								<p>
									<a class="modalbox" href="#inline"><img
										src="images/send-feedback-btn.jpg" width="50%"
										height="100%" /></a>
								</p>
							</div>
							<div style="width: 50%; float: left; display: block" id="cimg">						
							<p style="color:#999999">
							<a href="http://www.impetus.com">Impetus Infotech (India) Pvt. Ltd.</a><br>
Sarda House,
24-B, Palasia, A.B.Road,
Indore - 452 001,
India
Ph:  +91.731.4269300, 4069989,
Fax: +91.731.4071256
</p>
								<img src="images/contact-us.jpg" width="100%" height="130px" />
		
							</div>




						</div>
					</div>
				</div>
			</div>
			<!-- hidden inline form -->
			<div id="inline">
				<h2>Send us a Message</h2>

				<form id="contact" name="contact" action="#" method="post">
					<label for="email">Your E-mail</label> <input type="email"
						id="email" name="email" class="txt"> <br> <label
						for="msg">Enter a Message</label>
					<textarea id="msg" name="msg" class="txtarea"></textarea>

					<button id="send">Send E-mail</button>
				</form>
			</div>

			<div id="contents" style="width: 100%;">
				<div id="wowslider-container1">
					<div class="ws_images">
						<ul>
							<li><img src="images/stockmarketbanner.jpg"
								alt="Stock Definition" title="Stock Definition" id="wows1_0" /></li>

							<li><img src="images/topbanner.jpg" alt="You Can"
								title="You Can" id="wows1_2" /></li>
							<li><img src="images/banner_1.jpg"
								alt="Its easy for invester" title="Its easy for invester"
								id="wows1_3" /></li>
							<li><img src="images/banner_v5_01.jpg"
								alt="show and track real world"
								title="show and track real world" id="wows1_4" /></li>
						</ul>
					</div>
					<div class="ws_bullets">
						<div>
							<a href="#" title="Stock Definition"><img
								src="images/tooltips/stockmarketbanner.jpg"
								alt="Stock Definition" />1</a> <a href="#" title="You Can"><img
								src="images/tooltips/topbanner.jpg" alt="You Can" />2</a> <a
								href="#" title="Its easy for invester"><img
								src="images/tooltips/banner_1.jpg" alt="Its easy for invester" />3</a>
							<a href="#" title="show and track real world"><img
								src="images/tooltips/banner_v5_01.jpg"
								alt="show and track real world" />4</a>
						</div>
					</div>
				</div>
			</div>
			<footer> @Copyright:stock -moneytracker.com @All right
				reserved </footer>
</div>
		</div>
</body>
</html>
