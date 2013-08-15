package com.impetus.stockapp.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.impetus.stockapp.entity.Investor;
import com.impetus.stockapp.entity.InvestorStocksDetails;
import com.impetus.stockapp.exception.StockApplicationException;
import com.impetus.stockapp.service.InvestorStocksService;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@Controller
public class InvestorStockController {
    @Autowired
    private InvestorStocksService investorStocksService;
    private static Logger	 LOGGER = Logger.getLogger(LoginController.class);

    @RequestMapping(value = "profile.do", method = RequestMethod.GET)
    public String profile() {
	return "editprofile";
    }

    /**
     * Method deleteStock.
     * 
     * @param investerStockId
     *            Long
     * 
     * @return String
     */
    @RequestMapping(value = "/deleteStock.do", method = RequestMethod.GET)
    public @ResponseBody
    String deleteStock(@RequestParam("investerStockId") final Long investerStockId) {
	try {
	    if ((investorStocksService != null) && investorStocksService.deleteStock(investerStockId)) {
		return "success";
	    } else {

		return "fail";
	    }
	} catch (StockApplicationException e) {
	    LOGGER.error(e.getMessage(), e);
	}
	return "fail";
    }

    /**
     * Method addStock.
     * 
     * @param stockId
     *            Long
     * @param stockPurchaseDate
     *            Date
     * @param stockPurchasePrice
     *            double
     * @param varient
     *            Long
     * @param quantity
     *            int
     * @param emailAlertValue
     *            int
     * @param req
     *            HttpServletRequest
     * 
     * @return String
     */
    @RequestMapping(value = "/addStock.do", method = RequestMethod.POST)
    public @ResponseBody
    String addStock(@RequestParam("stockId") final Long stockId,
	    @RequestParam("stockPurchaseDate") final Date stockPurchaseDate,
	    @RequestParam("stockPurchasePrice") final double stockPurchasePrice,
	    @RequestParam("varient") final Long varient, @RequestParam("quantity") final int quantity,
	    @RequestParam("emailAlertValue") final int emailAlertValue, final HttpServletRequest req) {
	HttpSession session = req.getSession();
	Investor invester = (Investor) session.getAttribute("invster");
	String msg = "";
	if (invester != null) {
	    InvestorStocksDetails investorStocksDetails = new InvestorStocksDetails();
	    investorStocksDetails.setInvesterId(invester.getUserId());
	    investorStocksDetails.setStockId(stockId);
	    investorStocksDetails.setIsEmailAlertActivate(emailAlertValue);
	    investorStocksDetails.setPurchasedate(stockPurchaseDate);
	    investorStocksDetails.setQuantity(quantity);
	    investorStocksDetails.setVarient(varient);
	    investorStocksDetails.setPurchasePrice(stockPurchasePrice);
	    InvestorStocksDetails newInvesterStocksDetails;
	    try {
		newInvesterStocksDetails = investorStocksService.addOrUpdateStock(investorStocksDetails);
		if (newInvesterStocksDetails != null) {
		    msg = "success";
		} else {

		    msg = "No Stock added.";
		}
	    } catch (StockApplicationException e) {
		LOGGER.error(e.getMessage(), e);
		msg = e.getMessage();
	    }

	}
	return msg;

    }

    /**
     * Method updateStock.
     * 
     * @param varient
     *            Long
     * @param investerStockId
     *            Long
     * @param emailAlertValue
     *            int
     * @param req
     *            HttpServletRequest
     * 
     * @return String
     */
    @RequestMapping(value = "/updateStock.do", method = RequestMethod.POST)
    public @ResponseBody
    String updateStock(@RequestParam("varient") final Long varient,
	    @RequestParam("investerStockId") final Long investerStockId,
	    @RequestParam("emailAlertValue") final int emailAlertValue, final HttpServletRequest req) {
	int val = 0;
	if (investorStocksService != null) {
	    try {
		val = investorStocksService.resetEmailAlert(varient, emailAlertValue, investerStockId);
		if (val > 0) {
		    return "success";
		} else {

		    return "fail";
		}
	    } catch (StockApplicationException e) {
		LOGGER.error(e.getMessage(), e);
	    }
	}

	return "fail";

    }

    /**
     * Method updateInesterStock.
     * 
     * @param stockPurchaseDate
     *            Date
     * @param investerStockId
     *            Long
     * @param stockPurchasePrice
     *            double
     * @param quantity
     *            int
     * @param req
     *            HttpServletRequest
     * 
     * @return String
     */
    @RequestMapping(value = "/updateInesterStock.do", method = RequestMethod.POST)
    public @ResponseBody
    String updateInesterStock(@RequestParam("stockPurchaseDate") final Date stockPurchaseDate,
	    @RequestParam("investerStockId") final Long investerStockId,
	    @RequestParam("stockPurchasePrice") final double stockPurchasePrice,
	    @RequestParam("quantity") final int quantity, final HttpServletRequest req) {
	int val = 0;
	if (investorStocksService != null) {
	    try {
		val = investorStocksService.updateInvesterSTock(quantity, stockPurchaseDate, stockPurchasePrice,
			investerStockId);
		if (val > 0) {
		    return "success";
		} else {

		    return "fail";
		}
	    } catch (StockApplicationException e) {
		LOGGER.error(e.getMessage(), e);
	    }
	}
	return "fail";

    }

}
