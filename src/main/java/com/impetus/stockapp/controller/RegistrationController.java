package com.impetus.stockapp.controller;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.GenericValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.impetus.stockapp.entity.Investor;
import com.impetus.stockapp.exception.StockApplicationException;
import com.impetus.stockapp.mailutil.MailService;
import com.impetus.stockapp.service.InvestorService;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@Controller
public class RegistrationController {
    @Autowired
    private InvestorService investorService;

    @Autowired
    private MailService     mailService;
    private static Logger   LOGGER = Logger.getLogger(RegistrationController.class);

    /**
     * Method showForm.
     * 
     * @param invester
     *            Investor
     * 
     * @return ModelAndView
     */
    @RequestMapping(value = "/register.do", method = RequestMethod.GET)
    public ModelAndView showForm(@ModelAttribute("invester") Investor invester) {
	ModelAndView mav = new ModelAndView("registration");
	if (invester == null) {
	    invester = new Investor();
	}
	mav.addObject("invester", invester);
	return mav;
    }

    /**
     * Method submitForm.
     * 
     * @param invester
     *            Investor
     * 
     * @return String
     */
    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    @ResponseBody
    public String submitForm(@ModelAttribute("invester") final Investor invester) {
	if (invester != null) {
	    invester.setPassword(getSecurePassword());
	    invester.setPasswordSet(false);
	    Investor investerDetails;
	    try {
		investerDetails = investorService.addInvester(invester);
		if (investerDetails == null) {
		    LOGGER.debug("No invester Added");
		    return "fail";
		} else {
		    LOGGER.debug("Added invester in DB" + invester.toString());
		    String subject = "Stock-moneytracker-Registration Details";
		    String body = "Hi," + investerDetails.getFirstName() + "\n Your Username is : - "
			    + investerDetails.getUsername() + "\n Password is :" + investerDetails.getPassword();
		    LOGGER.debug("Sending mail after successfully registration");
		    mailService.sendMail("no-reply@yahoo.com", investerDetails.getEmail(), subject, body);
		    return investerDetails.getEmail();
		}
	    } catch (StockApplicationException e) {
		LOGGER.error(e.getMessage(), e);
	    }

	}
	return "fail";

    }

    @RequestMapping(value = "/profile.do", method = RequestMethod.POST)
    @ResponseBody
    public String profile(@ModelAttribute("invester") final Investor invester, final HttpServletRequest req) {
	if (invester != null) {
	    Long id = ((Investor) req.getSession().getAttribute("invster")).getUserId();
	    if (id > 0) {
		invester.setUserId(id);
		invester.setPasswordSet(true);
	    }
	    Investor investerDetails;
	    try {
		investerDetails = investorService.addInvester(invester);
		if (investerDetails == null) {
		    LOGGER.debug("No invester Added");
		    return "fail";
		} else {
		    LOGGER.debug("Updated invester in DB" + invester.toString());
		    req.getSession().setAttribute("invster", investerDetails);
		    return "success";
		}
	    } catch (StockApplicationException e) {
		LOGGER.error(e.getMessage(), e);
	    }

	}
	return "fail";

    }

    /**
     * Method changepassword.
     * 
     * @param invester
     *            Investor
     * @param req
     *            HttpServletRequest
     * 
     * @return String
     */
    @RequestMapping(value = "/changepassword.do", method = RequestMethod.POST)
    @ResponseBody
    public String changepassword(@ModelAttribute("invester") final Investor invester, final HttpServletRequest req) {
	if ((invester != null) && !GenericValidator.isBlankOrNull(invester.getPassword())) {
	    Investor oldInvestor = (Investor) (req.getSession().getAttribute("invster"));
	    oldInvestor.setPassword(invester.getPassword());
	    oldInvestor.setPasswordSet(true);
	    Investor investerDetails;
	    try {
		investerDetails = investorService.addInvester(oldInvestor);
		if (investerDetails == null) {
		    LOGGER.debug("Password has not been changed");
		    return "fail";
		} else {
		    LOGGER.debug("Password has been changed");
		    return "success";
		}
	    } catch (StockApplicationException e) {
		LOGGER.error(e.getMessage(), e);
	    }

	}
	return "fail";

    }

    /**
     * Method checkemailexist.
     * 
     * @param email
     *            String
     * 
     * @return String
     */
    @RequestMapping(value = "/checkemailexist.do", method = RequestMethod.POST)
    @ResponseBody
    public String checkemailexist(@RequestParam final String email) {
	if (!GenericValidator.isBlankOrNull(email)) {
	    long val;
	    try {
		val = investorService.emailExist(email);
		if (val != 0) {
		    LOGGER.debug("Email already registered");
		    return "fail";
		} else {
		    LOGGER.debug("Email not already registered");
		    return "success";
		}
	    } catch (StockApplicationException e) {
		LOGGER.error(e.getMessage(), e);
	    }

	}
	return "fail";

    }

    @RequestMapping(value = "/userNameExist.do", method = RequestMethod.POST)
    @ResponseBody
    public String userNameExist(@RequestParam final String user) {
	if (!GenericValidator.isBlankOrNull(user)) {
	    long val;
	    try {
		val = investorService.userNameExist(user);
		if (val != 0) {
		    LOGGER.debug("user already registered");
		    return "fail";
		} else {
		    LOGGER.debug("user not already registered");
		    return "success";
		}
	    } catch (StockApplicationException e) {
		LOGGER.error(e.getMessage(), e);
	    }

	}
	return "fail";

    }

    /**
     * Method getSecurePassword.
     * 
     * 
     * @return String
     */
    private String getSecurePassword() {
	SecureRandom random = new SecureRandom();
	return new BigInteger(130, random).toString(32);
    }

}
