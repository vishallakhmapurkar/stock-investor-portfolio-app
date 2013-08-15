function contactUs() {
		$(".modalbox").fancybox();
		$("#contact").submit(function() { return false; });

		
		$("#send").on("click", function(){
	
			var emailval  = $("#email").val();
			var msgval    = $("#msg").val();
			var msglen    = msgval.length;
					
						
			if(msglen >= 4) {
				// if both validate we attempt to send the e-mail
				// first we hide the submit btn so the user doesnt click twice
				$("#send").replaceWith("<em>sending...</em>");
					
				$.ajax({
					type: 'POST',
					url: 'contact.do',
					data: $.param({toemail:emailval,msg:msgval}),
					success: function(data) {
						if(data == "true") {
							$("#contact").fadeOut("fast", function(){
								$(this).before("<p><strong>Success! Your feedback has been sent, thanks :)</strong></p>");
								setTimeout("$.fancybox.close()", 1000);
							});
						}
					}
				});
			}
		});
	}
function forgetPassword(){
$.ajax({
	    type: 'post',
	    data: $.param({emailId:$('#femail').val()}),
	    url: 'getPassword.do',    
	    success: function(responseData) {
	   
	    	if(responseData!=''){
			  $.unblockUI();	
			   jAlert('Confirmed: ' + responseData,'Mail Send Confirmation Results');
	  $('#femail').val('');
			}
		
	  },cache: false,
	      error: function(XMLHttpRequest, textStatus, errorThrown) {
	          //TODO  
	      }
	  	
	  });
}
function ShowDialog(modal)
        {
            $("#overlay").show();
            $("#dialog").fadeIn(300);

            if (modal)
            {
                $("#overlay").unbind("click");
            }
            else
            {
                $("#overlay").click(function (e)
                {
                    HideDialog();
                });
            }
        }

        function HideDialog()
        {
            $("#overlay").hide();
            $("#dialog").fadeOut(300);
        } 
