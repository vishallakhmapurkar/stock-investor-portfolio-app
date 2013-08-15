<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader( "Pragma", "no-cache" );
response.setHeader( "Cache-Control", "no-cache" );
response.setDateHeader( "Expires", 0 ); 
  
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <script type = "text/javascript" >
       function preventBack(){window.history.forward();}
        setTimeout("preventBack()", 10);
        window.onunload=function(){null};
    </script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>www.moneytracker.com</title>

<style type="text/css">
.center {
	margin: auto;
	width: 982px;
	height: auto;
	border: thick;
	background-color: #dddddd;
}



#contentReg {
	background: #FFFFFF;
	padding: 2em;
	height: 500px;
	position: relative;
	z-index: 2;
	border-radius: 0 5px 5px 5px;
	box-shadow: 0 -2px 3px -2px rgba(0, 0, 0, .5);
}
</style>
<link rel="stylesheet" type="text/css" href="css/jquery.validate.css" />
<link rel="stylesheet" type="text/css" href="css/tabs.css" />
</script>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>

<script src="js/jquery.validate.js" type="text/javascript">
 </script>
<script src="js/jquery.validation.functions.js" type="text/javascript">
 </script>
<script type="text/javascript" src="js/jquery.alerts.js"></script>
<script type="text/javascript" src="js/jquery.blockUI.js"></script>

<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />
<script>
/*$(document).ready(function() {
validateForm();
$(".buttons2").click(function() 
{
var id = $(this).attr("id");
/*if(id=='step1')
{
  

$("#box2").slideDown(300);
$("#step2").slideDown(300);
}
else if(id=='step2')
{
					alert("Use this call to make AJAX submissions.");
					$.ajax({
        url: 'register',
        type: 'post',
        data: $('form#register').serialize(),
        success: function(data) {
        	var msg='';
        	if(data=='fail'){
        		msg = 'Registration fails;'
        	}else{
        		msg = 'Thank You For registering your password has been sent on your email id '+data+ ', Please check ur email.\n<a href="login">Click Here to Login</a>';
        	}
        	$("#step1").remove();
        	$("#step2").remove();
        	$("#tab1").slideUp('slow',function() {$("#tab1").remove();});
        	$("#thank").html(msg);
        	
        }
    });
});
	

}
else
{

}

return false;
});
	

	
});
*/
            /* <![CDATA[ */
          jQuery(function(){
		  var element = document.getElementById('state');
    element.value = '<c:out value="${invster.state}" />';
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
		  $('#email').blur(function() {
                if ($('#email').val()) {
                  
				   checkEmailIdAlreadyRegistered($('#email').val());
                }
            });
                jQuery("#firstName").validate({
                    expression: "if (VAL) return true; else return false;",
                    message: "Please enter the Required field"
                });
				jQuery("#lastName").validate({
                    expression: "if (VAL) return true; else return false;",
                    message: "Please enter the Required field"
                });
				jQuery("#mobile").validate({
                    expression: "if (VAL) return true; else return false;",
                    message: "Please enter the Required field"
                });
				jQuery("#username").validate({
                    expression: "if (VAL) return true; else return false;",
                    message: "Please enter the Required field"
                });
				jQuery("#password").validate({
                    expression: "if (VAL) return true; else return false;",
                    message: "Please enter the Required field"
                });
				jQuery("#password").validate({
                    expression: "if (VAL.length<5) return false; else return true;",
                    message: "Please enter password length greater than 5"
					
                });
				jQuery("#email").validate({
                    expression: "if (VAL) return true; else return false;",
                    message: "Please enter the Required field"
                });
				jQuery("#addressLineOne").validate({
                    expression: "if (VAL) return true; else return false;",
                    message: "Please enter the Required field"
                });
				jQuery("#addressLineTwo").validate({
                    expression: "if (VAL) return true; else return false;",
                    message: "Please enter the Required field"
                });
				jQuery("#city").validate({
                    expression: "if (VAL) return true; else return false;",
                    message: "Please enter the Required field"
                });
				jQuery("#postalcode").validate({
                    expression: "if (VAL) return true; else return false;",
                    message: "Please enter the Required field"
                });
				 
				 jQuery("#mobile").validate({
                    expression: "if (VAL.match(/^[9][0-9]{9}$/)) return true; else return false;",
                    message: "Should be a valid 10 digit Mobile Number"
                });
                jQuery("#mobile").validate({
                    expression: "if (VAL.match(/^[0-9]*$/) && VAL) return true; else return false;",
                    message: "Please enter a valid integer"
                });
				 jQuery("#state").validate({
                    expression: "if (VAL != '0') return true; else return false;",
                    message: "Please make a selection"
                });
                jQuery("#postalcode").validate({
                    expression: "if (!isNaN(VAL) && VAL) return true; else return false;",
                    message: "Please enter a valid number"
                });
                jQuery("#postalcode").validate({
                    expression: "if (VAL.match(/^[0-9]*$/) && VAL) return true; else return false;",
                    message: "Please enter a valid integer"
                });
               
                jQuery("#email").validate({
                    expression: "if (VAL.match(/^[^\\W][a-zA-Z0-9\\_\\-\\.]+([a-zA-Z0-9\\_\\-\\.]+)*\\@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*\\.[a-zA-Z]{2,4}$/)) return true; else return false;",
                    message: "Please enter a valid Email ID"
                });
             
				jQuery('.AdvancedForm').validated(function(){
				$('#step2').attr("disabled", "disabled");
				
				
				
					$.ajax({
        url: 'profile.do',
        type: 'post',
        data: $('form#register').serialize(),
        success: function(data) {
        	var msg='';
        	if(data=='fail'){
        		msg = 'Registration fails;'
        	}else{
        		msg = 'Profile update sucessfully';
        	}
        	$("#box1").remove();
        	$("#box2").remove();
        	$("#tab1").slideUp('slow',function() {$("#tab1").remove();});
        	$("#thank").html(msg);
        	
        }
    });
					
});
            });
			
			function checkEmailIdAlreadyRegistered(email){
			   $.ajax({
        url: 'checkemailexist.do',
        type: 'post',
        data: $.param({email:email}),
        success: function(data) {
        	if(data=='fail'){
			jAlert('Email Id already exist: ', 'Email error');
			$('#email').val('');
			 $('input:submit').attr("disabled", true);
			}else{
			 $('input:submit').attr("disabled", false);
			}
			
        	
        },cache: false
    });   
			}
			
			
	
			

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
	display: block;
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
	display: block;
}

#step3 {
	display: none;
}
</style>

</head>

<body>
	<div class="center">
<div style="width: 100%; height: 80px;background-color:#000000">
			 <a href="logout.do"
				style="color: #FFFFFF">Log out</a> 
		</div>
		<div style="width: 100%; height: 251px; margin-top: -6%">
			<img src="images/page-banner-investments.jpg" width="100%"
				height="100%" />
		</div>
		<div id="midd"
			style="background-color: #232323; width: 100%; height: auto;">
			<div id="menuActive" style="width: 100%; margin-top: -5%;">
				<ul id="tabs">
					<li><a href="#" name="tab1">Edit Profile</a></li>

				</ul>

				<div id="contentReg">
				<a href="welcome.do" >Back </a>
					<div id="tab1">
						<form action="" id="register" class="AdvancedForm">

							<div id="box1">
								<fieldset>
									<legend style="color:#000000">Personal Details</legend>

									<table width="810" border="0">
										<tr>
											<td width="194"><label>First Name (*)</label><input type="text" name="firstName"
												id="firstName" value="${invster.firstName}"></td>
											<td width="202"><label>Last Name (*)</label><input type="text" name="lastName"
												id="lastName" value="${invster.lastName}" ></td>
											<td colspan="2"><label>Mobile (*)</label><br><input type="text" name="mobile"
												id="mobile" value="${invster.mobile}"></td>
										</tr>
										<tr>
											<td colspan="2"></td>
											<td colspan="2">&nbsp;</td>
										</tr>
										<tr>
											<td colspan="2"><label>User Name (*)</label><br><input type="text" name="username"
												id="username" value="${invster.username}"></td>
											<td width="205"><label>Password (*)</label><br><input type="password" name="password"
												id="password" value="${invster.password}"></td>
											<td width="191">&nbsp;</td>
										</tr>
										<tr>
											<td colspan="2">&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td colspan="2"><label>Email (*)</label><br><input type="text" name="email"
												id="email" value="${invster.email}"></td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td colspan="2">&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
									</table>

								</fieldset>
							</div>

							<div id="box2">
								<fieldset>
									<legend style="color:#000000">Correspondence Details</legend>
									<table width="810" border="0">
										<tr>
											<td width="194"><label>Address Line One (*)</label><input type="text" name="addressLineOne"
												id="addressLineOne" value="${invster.addressLineOne}"></td>
											<td width="202"><label>Address Line Two (*)</label><input type="text" name="addressLineTwo"
												id="addressLineTwo" value="${invster.addressLineTwo}"></td>
											<td colspan="2"><label>City (*)</label><br><input type="text" name="city" id="city"
												value="${invster.city}"></td>
										</tr>
										<tr>
											<td colspan="2"></td>
											<td colspan="2">&nbsp;</td>
										</tr>
										<tr>
											<td colspan="2"><label>Select
														Country (*)</label><br><select name="state" id="state">
														
													<option value="0" selected="selected"></option>
													<option value="Afghanistan">Afghanistan</option>
													<option value="Albania">Albania</option>
													<option value="Algeria">Algeria</option>
													<option value="Andorra">Andorra</option>
													<option value="Antigua and Barbuda">Antigua and
														Barbuda</option>
													<option value="Argentina">Argentina</option>
													<option value="Armenia">Armenia</option>
													<option value="Australia">Australia</option>
													<option value="Austria">Austria</option>
													<option value="Azerbaijan">Azerbaijan</option>
													<option value="Bahamas">Bahamas</option>
													<option value="Bahrain">Bahrain</option>
													<option value="Bangladesh">Bangladesh</option>
													<option value="Barbados">Barbados</option>
													<option value="Belarus">Belarus</option>
													<option value="Belgium">Belgium</option>
													<option value="Belize">Belize</option>
													<option value="Benin">Benin</option>
													<option value="Bhutan">Bhutan</option>
													<option value="Bolivia">Bolivia</option>
													<option value="Bosnia and Herzegovina">Bosnia and
														Herzegovina</option>
													<option value="Botswana">Botswana</option>
													<option value="Brazil">Brazil</option>
													<option value="Brunei">Brunei</option>
													<option value="Bulgaria">Bulgaria</option>
													<option value="Burkina Faso">Burkina Faso</option>
													<option value="Burundi">Burundi</option>
													<option value="Cambodia">Cambodia</option>
													<option value="Cameroon">Cameroon</option>
													<option value="Canada">Canada</option>
													<option value="Cape Verde">Cape Verde</option>
													<option value="Central African Republic">Central
														African Republic</option>
													<option value="Chad">Chad</option>
													<option value="Chile">Chile</option>
													<option value="China">China</option>
													<option value="Colombia">Colombia</option>
													<option value="Comoros">Comoros</option>
													<option value="Congo">Congo</option>
													<option value="Costa Rica">Costa Rica</option>
													<option value="Côte d'Ivoire">Côte d'Ivoire</option>
													<option value="Croatia">Croatia</option>
													<option value="Cuba">Cuba</option>
													<option value="Cyprus">Cyprus</option>
													<option value="Czech Republic">Czech Republic</option>
													<option value="Denmark">Denmark</option>
													<option value="Djibouti">Djibouti</option>
													<option value="Dominica">Dominica</option>
													<option value="Dominican Republic">Dominican
														Republic</option>
													<option value="East Timor">East Timor</option>
													<option value="Ecuador">Ecuador</option>
													<option value="Egypt">Egypt</option>
													<option value="El Salvador">El Salvador</option>
													<option value="Equatorial Guinea">Equatorial
														Guinea</option>
													<option value="Eritrea">Eritrea</option>
													<option value="Estonia">Estonia</option>
													<option value="Ethiopia">Ethiopia</option>
													<option value="Fiji">Fiji</option>
													<option value="Finland">Finland</option>
													<option value="France">France</option>
													<option value="Gabon">Gabon</option>
													<option value="Gambia">Gambia</option>
													<option value="Georgia">Georgia</option>
													<option value="Germany">Germany</option>
													<option value="Ghana">Ghana</option>
													<option value="Greece">Greece</option>
													<option value="Grenada">Grenada</option>
													<option value="Guatemala">Guatemala</option>
													<option value="Guinea">Guinea</option>
													<option value="Guinea-Bissau">Guinea-Bissau</option>
													<option value="Guyana">Guyana</option>
													<option value="Haiti">Haiti</option>
													<option value="Honduras">Honduras</option>
													<option value="Hong Kong">Hong Kong</option>
													<option value="Hungary">Hungary</option>
													<option value="Iceland">Iceland</option>
													<option value="India">India</option>
													<option value="Indonesia">Indonesia</option>
													<option value="Iran">Iran</option>
													<option value="Iraq">Iraq</option>
													<option value="Ireland">Ireland</option>
													<option value="Israel">Israel</option>
													<option value="Italy">Italy</option>
													<option value="Jamaica">Jamaica</option>
													<option value="Japan">Japan</option>
													<option value="Jordan">Jordan</option>
													<option value="Kazakhstan">Kazakhstan</option>
													<option value="Kenya">Kenya</option>
													<option value="Kiribati">Kiribati</option>
													<option value="North Korea">North Korea</option>
													<option value="South Korea">South Korea</option>
													<option value="Kuwait">Kuwait</option>
													<option value="Kyrgyzstan">Kyrgyzstan</option>
													<option value="Laos">Laos</option>
													<option value="Latvia">Latvia</option>
													<option value="Lebanon">Lebanon</option>
													<option value="Lesotho">Lesotho</option>
													<option value="Liberia">Liberia</option>
													<option value="Libya">Libya</option>
													<option value="Liechtenstein">Liechtenstein</option>
													<option value="Lithuania">Lithuania</option>
													<option value="Luxembourg">Luxembourg</option>
													<option value="Macedonia">Macedonia</option>
													<option value="Madagascar">Madagascar</option>
													<option value="Malawi">Malawi</option>
													<option value="Malaysia">Malaysia</option>
													<option value="Maldives">Maldives</option>
													<option value="Mali">Mali</option>
													<option value="Malta">Malta</option>
													<option value="Marshall Islands">Marshall Islands</option>
													<option value="Mauritania">Mauritania</option>
													<option value="Mauritius">Mauritius</option>
													<option value="Mexico">Mexico</option>
													<option value="Micronesia">Micronesia</option>
													<option value="Moldova">Moldova</option>
													<option value="Monaco">Monaco</option>
													<option value="Mongolia">Mongolia</option>
													<option value="Montenegro">Montenegro</option>
													<option value="Morocco">Morocco</option>
													<option value="Mozambique">Mozambique</option>
													<option value="Myanmar">Myanmar</option>
													<option value="Namibia">Namibia</option>
													<option value="Nauru">Nauru</option>
													<option value="Nepal">Nepal</option>
													<option value="Netherlands">Netherlands</option>
													<option value="New Zealand">New Zealand</option>
													<option value="Nicaragua">Nicaragua</option>
													<option value="Niger">Niger</option>
													<option value="Nigeria">Nigeria</option>
													<option value="Norway">Norway</option>
													<option value="Oman">Oman</option>
													<option value="Pakistan">Pakistan</option>
													<option value="Palau">Palau</option>
													<option value="Panama">Panama</option>
													<option value="Papua New Guinea">Papua New Guinea</option>
													<option value="Paraguay">Paraguay</option>
													<option value="Peru">Peru</option>
													<option value="Philippines">Philippines</option>
													<option value="Poland">Poland</option>
													<option value="Portugal">Portugal</option>
													<option value="Puerto Rico">Puerto Rico</option>
													<option value="Qatar">Qatar</option>
													<option value="Romania">Romania</option>
													<option value="Russia">Russia</option>
													<option value="Rwanda">Rwanda</option>
													<option value="Saint Kitts and Nevis">Saint Kitts
														and Nevis</option>
													<option value="Saint Lucia">Saint Lucia</option>
													<option value="Saint Vincent and the Grenadines">Saint
														Vincent and the Grenadines</option>
													<option value="Samoa">Samoa</option>
													<option value="San Marino">San Marino</option>
													<option value="Sao Tome and Principe">Sao Tome and
														Principe</option>
													<option value="Saudi Arabia">Saudi Arabia</option>
													<option value="Senegal">Senegal</option>
													<option value="Serbia and Montenegro">Serbia and
														Montenegro</option>
													<option value="Seychelles">Seychelles</option>
													<option value="Sierra Leone">Sierra Leone</option>
													<option value="Singapore">Singapore</option>
													<option value="Slovakia">Slovakia</option>
													<option value="Slovenia">Slovenia</option>
													<option value="Solomon Islands">Solomon Islands</option>
													<option value="Somalia">Somalia</option>
													<option value="South Africa">South Africa</option>
													<option value="Spain">Spain</option>
													<option value="Sri Lanka">Sri Lanka</option>
													<option value="Sudan">Sudan</option>
													<option value="Suriname">Suriname</option>
													<option value="Swaziland">Swaziland</option>
													<option value="Sweden">Sweden</option>
													<option value="Switzerland">Switzerland</option>
													<option value="Syria">Syria</option>
													<option value="Taiwan">Taiwan</option>
													<option value="Tajikistan">Tajikistan</option>
													<option value="Tanzania">Tanzania</option>
													<option value="Thailand">Thailand</option>
													<option value="Togo">Togo</option>
													<option value="Tonga">Tonga</option>
													<option value="Trinidad and Tobago">Trinidad and
														Tobago</option>
													<option value="Tunisia">Tunisia</option>
													<option value="Turkey">Turkey</option>
													<option value="Turkmenistan">Turkmenistan</option>
													<option value="Tuvalu">Tuvalu</option>
													<option value="Uganda">Uganda</option>
													<option value="Ukraine">Ukraine</option>
													<option value="United Arab Emirates">United Arab
														Emirates</option>
													<option value="United Kingdom">United Kingdom</option>
													<option value="United States">United States</option>
													<option value="Uruguay">Uruguay</option>
													<option value="Uzbekistan">Uzbekistan</option>
													<option value="Vanuatu">Vanuatu</option>
													<option value="Vatican City">Vatican City</option>
													<option value="Venezuela">Venezuela</option>
													<option value="Vietnam">Vietnam</option>
													<option value="Yemen">Yemen</option>
													<option value="Zambia">Zambia</option>
													<option value="Zimbabwe">Zimbabwe</option>

											</select></td>
											<td width="205">&nbsp;</td>
											<td width="191">&nbsp;</td>
										</tr>
										<tr>
											<td colspan="2">&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td colspan="2"><label>Postal Code (*)</label><br><input type="text" name="postalcode"
												id="postalcode" value="${invster.postalcode}"></td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td colspan="2">&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
									</table>
<input type="submit" class="buttons" id="step2"
								value=" Update Your Details " style="cursor: pointer" />
								</fieldset>
							</div>
							&nbsp; &nbsp; 

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
