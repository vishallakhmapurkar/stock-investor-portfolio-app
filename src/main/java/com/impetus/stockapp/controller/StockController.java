package com.impetus.stockapp.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.impetus.stockapp.bean.InvestorStock;
import com.impetus.stockapp.config.AppConfig;
import com.impetus.stockapp.entity.Investor;
import com.impetus.stockapp.entity.Stock;
import com.impetus.stockapp.entity.StockPerDayDetail;
import com.impetus.stockapp.entity.StockYearDetail;
import com.impetus.stockapp.exception.StockApplicationException;
import com.impetus.stockapp.service.StockChartService;
import com.impetus.stockapp.service.StockService;
import com.impetus.stockapp.util.HttpUtil;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@Controller
public class StockController {
    private static Logger     LOGGER = Logger.getLogger(StockController.class);
    @Autowired
    private StockService      stockServiceImpl;
    @Autowired
    private StockChartService stockChartService;
    
    @Autowired
    private AppConfig         conf;
    
    /**
     * Method getStocks.
     * 
     * @param time
     *            String
     * @param req
     *            HttpServletRequest
     * 
     * @return List<InvestorStock>
     */
    @RequestMapping(value = "/getInvesterstock.do", method = RequestMethod.GET)
    @ResponseBody
    public List<InvestorStock> getStocks(@RequestParam final String time, final HttpServletRequest req) {
	HttpSession session = req.getSession();
	Investor invester = (Investor) session.getAttribute("invster");
	
	List<InvestorStock> stocks = null;
	if (invester != null) {
	    LOGGER.info("invester.getUserId():" + invester.getUserId());
	    try {
		stocks = HttpUtil.getInvesterStockList(conf.getWebServicePath() + invester.getUserId() + "&time="
		        + time);
		LOGGER.info(stocks.size());
	    } catch (StockApplicationException e) {
		LOGGER.error(e.getMessage());
	    }
	}
	
	return stocks;
    }
    
    /**
     * Method getFullData.
     * 
     * @param time
     *            String
     * @param req
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     */
    @RequestMapping(value = "/getStockCSV.do", method = RequestMethod.GET)
    @ResponseBody
    // indicate to use a compatible HttpMessageConverter
    public void getFullData(@RequestParam final String time, final HttpServletRequest req,
	    final HttpServletResponse response) {
	HttpSession session = req.getSession();
	Investor invester = (Investor) session.getAttribute("invster");
	
	List<InvestorStock> stocks = null;
	if (invester != null) {
	    LOGGER.info("invester.getUserId():" + invester.getUserId());
	    try {
		stocks = HttpUtil.getInvesterStockList(conf.getWebServicePath() + invester.getUserId() + "&time="
		        + time);
		// Create file
		File filename = new File("out.csv");
		
		FileWriter fstream = new FileWriter(filename);
		BufferedWriter out = new BufferedWriter(fstream);
		out.write("Company Name," + "Current Stock Price," + "Email Alert(0(Deactivate)/1(Activate)),"
		        + "Invester Amount Status(Gain(+)/Loss(-))," + "Quantity," + "Stock Purchase Price,"
		        + "Stock Ticker Symbol," + "Varience Value," + "Stock Purchase Date\n");
		
		for (InvestorStock investorStock : stocks) {
		    
		    out.write(investorStock.getCompanyName() + "," + investorStock.getCurrPrice() + ","
			    + investorStock.getEmailAlert() + "," + investorStock.getInvesterAmountStatus() + ","
			    + investorStock.getQuantity() + "," + investorStock.getStockPurchasePrice() + ","
			    + investorStock.getStockSymbol() + "," + investorStock.getVarient() + ","
			    + investorStock.getStockPurchasedate() + "\n");
		    // out.write(",");
		    
		}
		out.close();
		FileInputStream inputStream = new FileInputStream(filename.getCanonicalPath()); // read the file
		
		try {
		    // get your file as InputStream
		    
		    // copy it to response's OutputStream
		    IOUtils.copy(inputStream, response.getOutputStream());
		    response.setContentType("text/csv;charset=utf-8");
		    response.setHeader("Content-Disposition", "attachment; filename=" + filename);
		    response.flushBuffer();
		    
		} catch (IOException ex) {
		    throw new RuntimeException("IOError writing file to output stream");
		}
		
		// out.write(a.toString());
		// Close the output stream
		
		LOGGER.info(stocks.size());
	    } catch (StockApplicationException e) {
		LOGGER.error(e.getMessage());
	    } catch (Exception e) {// Catch exception if any
		LOGGER.error("Error: " + e.getMessage());
	    }
	}
	
	// return new CsvResponse(stocks, invester.getFirstName()+" Stock.csv");
    }
    
    /**
     * Method getStockByStockSymbolOrCompanyname.
     * 
     * @param pattern
     *            String
     * @param req
     *            HttpServletRequest
     * 
     * @return List<Stock>
     */
    @RequestMapping(value = "/getStockByStockSymbolOrCompanyname.do", method = RequestMethod.GET)
    @ResponseBody
    public List<Stock> getStockByStockSymbolOrCompanyname(@RequestParam("pattern") final String pattern,
	    final HttpServletRequest req) {
	
	try {
	    return stockServiceImpl.searchForStock(pattern);
	} catch (StockApplicationException e) {
	    LOGGER.error(e.getMessage(), e);
	    return null;
	}
    }
    
    /**
     * Method getStockChart.
     * 
     * @param stockID
     *            Long
     * @param req
     *            HttpServletRequest
     * 
     * @return Object[]
     */
    @RequestMapping(value = "/getStockChart.do", method = RequestMethod.GET)
    @ResponseBody
    public Object[] getStockChart(@RequestParam("stockID") final Long stockID, final HttpServletRequest req) {
	List<StockYearDetail> investerStocksDetails;
	Object[] obj = null;
	try {
	    investerStocksDetails = stockChartService.getYearlyStockDetails(stockID);
	    java.sql.Timestamp timeStampDate;
	    obj = new Object[investerStocksDetails.size()];
	    for (int i = 0; i < investerStocksDetails.size(); i++) {
		timeStampDate = new Timestamp(investerStocksDetails.get(i).getStockEntryDate().getTime());
		Object[] str = { timeStampDate, investerStocksDetails.get(i).getPrice() };
		obj[i] = str;
		
	    }
	} catch (StockApplicationException e) {
	    LOGGER.error(e.getMessage(), e);
	    
	}
	
	return obj;
    }
    
    @RequestMapping(value = "/getDayStockChart.do", method = RequestMethod.GET)
    @ResponseBody
    public Object[] getDayStockChart(@RequestParam("dat") final Date dt, @RequestParam("stockID") final Long stockID,
	    final HttpServletRequest req) {
	List<StockPerDayDetail> investerStocksDetails;
	Object[] obj = null;
	try {
	    investerStocksDetails = stockChartService.getDayStockDetails(stockID, dt);
	    java.sql.Timestamp timeStampDate;
	    obj = new Object[investerStocksDetails.size()];
	    for (int i = 0; i < investerStocksDetails.size(); i++) {
		timeStampDate = investerStocksDetails.get(i).getDaytime();
		Object[] str = { timeStampDate, investerStocksDetails.get(i).getPrice() };
		obj[i] = str;
		
	    }
	} catch (StockApplicationException e) {
	    LOGGER.error(e.getMessage(), e);
	    
	}
	
	return obj;
    }
    
    /**
     * Method downloadFile.
     * 
     * @param resp
     *            HttpServletResponse
     * 
     * 
     * @return String * @throws IOException
     */
    @RequestMapping(value = "/getStockCSV2.do", method = RequestMethod.GET)
    public String downloadFile(HttpServletResponse resp) throws IOException {
	Writer output = null;
	String text = "Rajesh Kumar";
	File file = new File("write.txt");
	output = new BufferedWriter(new FileWriter(file));
	output.write(text);
	output.close();
	resp.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
	OutputStream out = resp.getOutputStream();
	resp.setContentType("text/plain; charset=utf-8");
	FileInputStream fi = new FileInputStream(file);
	
	out.flush();
	out.close();
	
	return null;
    }
    
    /**
     * Method getChart.
     * 
     * @param stockID
     *            Long
     * @param stockSymbol
     *            String
     * @param map
     *            ModelMap
     * 
     * @return String
     */
    @RequestMapping(value = "/getChart.do", method = RequestMethod.GET)
    public String getChart(@RequestParam("stockID") final Long stockID,
	    @RequestParam("stockSymbol") final String stockSymbol, final ModelMap map) {
	map.put("stockID", stockID);
	map.put("stockSymbol", stockSymbol);
	return "chart";
	
    }
    
    /**
     * Method getLiveStock.
     * 
     * @param stockID
     *            Long
     * 
     * @return Stock
     */
    @RequestMapping(value = "/getLiveStock.do", method = RequestMethod.POST)
    @ResponseBody
    public Stock getLiveStock(@RequestParam("stockID") final Long stockID) {
	Stock stock = null;
	try {
	    stock = stockServiceImpl.getLiveStock(stockID);
	} catch (StockApplicationException e) {
	    LOGGER.error(e.getMessage(), e);
	    
	}
	/*
	 * long newprice = stock.getFaceValue(); stock.setFaceValue(newprice);
	 */
	return stock;
    }
    
    /**
     * Method getNumber.
     * 
     * 
     * @return int
     */
    private int getNumber() {
	// Example assumes these variables have been initialized
	// above, e.g. as method parameters or otherwise
	Random rand = new Random();
	int min = -20;
	int max = 20;
	
	// nextInt is normally exclusive of the top value,
	// so add 1 to make it inclusive
	int randomNum = rand.nextInt((max - min) + 1) + min;
	return randomNum;
    }
}
