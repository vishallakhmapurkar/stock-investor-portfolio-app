package com.impetus.stockapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.impetus.stockapp.service.LoginService;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService  loginService;
    private static Logger LOGGER = Logger.getLogger(LoginController.class);
    @Autowired
    private MailService   mailService;

    /**
     * Method getpassword.
     * 
     * @param emailId
     *            String
     * 
     * @return String
     */
    @RequestMapping(value = "/getPassword.do", method = RequestMethod.POST)
    @ResponseBody
    public String getpassword(@RequestParam("emailId") final String emailId) {

	String mailMsg = "";
	Investor investor;
	try {
	    investor = loginService.getPassword(emailId);
	    if (investor != null) {
		String body = "";

		body = "Hi \n This is your User name: " + investor.getUsername() + "\n And password is :"
			+ investor.getPassword();
		try {
		    mailService.sendMail("no-reply@yahoo.com", emailId, "Money Tracker crediatials", body);
		    mailMsg = "Mail Sent successfully to your mail id :" + emailId;
		    LOGGER.debug(mailMsg);
		} catch (Exception e) {
		    mailMsg = "Sorry Mail Sending Error";
		    LOGGER.error(mailMsg + e.getMessage());
		}
	    } else {
		mailMsg = "Please enter your registered email id";
		LOGGER.debug(mailMsg);
	    }
	} catch (StockApplicationException e1) {
	    mailMsg = e1.getMessage();
	    LOGGER.error(e1.getMessage());
	}

	return mailMsg;

    }

    /**
     * Method loginCheck.
     * 
     * @param invester
     *            Investor
     * @param req
     *            HttpServletRequest
     * 
     * @return ModelAndView
     */
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public ModelAndView loginCheck(@ModelAttribute("invester") final Investor invester, final HttpServletRequest req) {
	LOGGER.debug("Login with post method");
	ModelAndView modelAndView = new ModelAndView();
	HttpSession session = req.getSession();
	Investor validInvestor;
	try {
	    validInvestor = loginService.authenticateUser(invester.getUsername(), invester.getPassword());
	    if (validInvestor == null) {
		modelAndView.setViewName("home");
		session.setAttribute("error", "Invalid Username or Password");
		LOGGER.debug("Login failed");

	    } else if (validInvestor.isPasswordSet()) {
		modelAndView.setViewName("redirect:/welcome.do");
		modelAndView.addObject("invester", validInvestor);

		session.setAttribute("invster", validInvestor);
		LOGGER.debug("login success ");
	    } else {
		session.setAttribute("invster", validInvestor);
		LOGGER.debug("no password set ");
		modelAndView.setViewName("change");

	    }
	} catch (StockApplicationException e) {
	    session.setAttribute("error", e.getMessage());
	    modelAndView.setViewName("home");
	    LOGGER.error(e.getMessage(), e);
	}

	return modelAndView;
    }

    /**
     * Method logout.
     * 
     * @param invester
     *            Investor
     * @param req
     *            HttpServletRequest
     * 
     * @return ModelAndView
     */
    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    public ModelAndView logout(@ModelAttribute("invester") final Investor invester, final HttpServletRequest req) {
	req.getSession(false);
	req.getSession().invalidate();
	LOGGER.debug("log out ");
	return new ModelAndView("home");

    }

    /**
     * Method showForm.
     * 
     * @param invester
     *            Investor
     * @param req
     *            HttpServletRequest
     * 
     * @return ModelAndView
     */
    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public ModelAndView showForm(@ModelAttribute("invester") Investor invester, final HttpServletRequest req) {
	LOGGER.debug("Login with get method");
	ModelAndView mav = new ModelAndView("home");
	if (invester == null) {
	    invester = new Investor();
	}
	HttpSession session = req.getSession();
	session.setAttribute("error", "");
	mav.addObject("invester", invester);
	return mav;
    }

    /**
     * Method welcome.
     * 
     * @param invester
     *            Investor
     * 
     * @return ModelAndView
     */
    @RequestMapping(value = "/welcome.do", method = RequestMethod.GET)
    public ModelAndView welcome(@ModelAttribute("invester") final Investor invester) {
	ModelAndView mav = new ModelAndView("loginsuccess");

	return mav;
    }
}
