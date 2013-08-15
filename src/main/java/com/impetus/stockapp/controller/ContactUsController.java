package com.impetus.stockapp.controller;

import org.apache.commons.validator.GenericValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.impetus.stockapp.mailutil.MailService;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@Controller
public class ContactUsController {
    @Autowired
    private MailService   mailService;
    private static Logger LOGGER = Logger.getLogger(ContactUsController.class);

    /**
     * Method submitForm.
     * 
     * @param toemail
     *            String
     * @param msg
     *            String
    
     * @return String */
    @RequestMapping(value = "/contact.do", method = RequestMethod.POST)
    @ResponseBody
    public String submitForm(@RequestParam("toemail") final String toemail, @RequestParam("msg") final String msg) {

	String result = "";
	if (!GenericValidator.isBlankOrNull(toemail) && !GenericValidator.isBlankOrNull(msg)) {
	    String subject = "Stock Moneytracker feedback";
	    String body = "Hi, \n An feed back comes from this email id :" + toemail + "With message " + msg;
	    try {
		mailService.sendMail("no-reply@yahoo.com", "lakhmapurkarvishal@yahoo.com", subject, body);
		mailService.sendMail("no-reply@yahoo.com", toemail, subject,
		        "Thankyou for giving us feedback. Your feedback is important for us.");
		result = "true";
	    } catch (Exception e) {
		LOGGER.error(e.getMessage());
		result = "false";
	    }
	}

	return result;
    }

}
