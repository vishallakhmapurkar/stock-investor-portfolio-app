package com.impetus.stockapp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.commons.validator.GenericValidator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import com.impetus.stockapp.bean.InvestorStock;
import com.impetus.stockapp.exception.StockApplicationException;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
public class HttpUtil {
    private static Logger LOGGER = Logger.getLogger(HttpUtil.class);

    /**
     * Method getInvesterStockList.
     * @param url String
    
    
     * @return List<InvestorStock> * @throws StockApplicationException */
    public static List<InvestorStock> getInvesterStockList(final String url) throws StockApplicationException {

    	List<InvestorStock> stocks = new ArrayList<InvestorStock>();
	if(!GenericValidator.isBlankOrNull(url)){
		
		// Create the httpclient
		HttpClient httpclient = new DefaultHttpClient();

		// Prepare a request object
		HttpGet httpget = new HttpGet(url);

		// Execute the request
		HttpResponse response;

		try {

		    // Open the webpage.
		    response = httpclient.execute(httpget);
		    LOGGER.info("response:" + response);
		    if (response.getStatusLine().getStatusCode() == 200) {
			// Connection was established. Get the content.

			HttpEntity entity = response.getEntity();
			// If the response does not enclose an entity, there is no need
			// to worry about connection release

			if (entity != null) {
			    // A Simple JSON Response Read
			    InputStream instream = entity.getContent();

			    // the way to parse JSON array
			    JSONArray json = (JSONArray) JSONSerializer.toJSON(convertStreamToString(instream));

			    for (int i = 0; i < json.size(); i++) {
				// getting a JSON object inside JSON array
				JSONObject jStockRec = json.getJSONObject(i);
				InvestorStock investorStock = new InvestorStock();
				investorStock.setCurrPrice(Double.parseDouble(jStockRec.getString("currPrice")));
				investorStock.setEmailAlert(Integer.parseInt(jStockRec.getString("emailAlert")));
				investorStock.setFaceValue(Double.parseDouble(jStockRec.getString("faceValue")));
				investorStock.setCompanyName(jStockRec.getString("companyName"));
				investorStock.setInvesterAmountStatus(Double.parseDouble(jStockRec
				        .getString("investerAmountStatus")));
				investorStock.setQuantity(Integer.parseInt(jStockRec.getString("quantity")));
				investorStock.setStockID(Long.parseLong(jStockRec.getString("stockID")));
				investorStock.setStockPurchasePrice(Double.parseDouble(jStockRec
				        .getString("stockPurchasePrice")));
				investorStock.setStockSymbol(jStockRec.getString("stockSymbol"));
				investorStock.setVarient(Double.parseDouble(jStockRec.getString("varient")));
				investorStock.setStockPurchasedate(Date.valueOf(jStockRec.getString("stockPurchasedate")));
				investorStock.setInvesterStockID(Long.parseLong(jStockRec.getString("investerStockID")));
				stocks.add(investorStock);

			    }

			    // Cose the stream.
			    instream.close();
			}
		    }
		} catch (IOException ex) {
		    LOGGER.error(ex.getMessage());
		    throw new StockApplicationException();
		} catch (JSONException ex) {
		    LOGGER.error(ex.getMessage());
		    throw new StockApplicationException();
		}
		LOGGER.info("stocks.size:" + stocks.size());
	}
		
	return stocks;
    }

    /**
     * Method convertStreamToString.
     * @param is InputStream
    
     * @return String */
    private static String convertStreamToString(final InputStream is) {
	/*
	 * To convert the InputStream to String we use the BufferedReader.readLine() method. We iterate until the
	 * BufferedReader return null which means there's no more data to read. Each line will appended to a
	 * StringBuilder and returned as String.
	 */
	BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	StringBuilder sb = new StringBuilder();

	String line = null;
	try {
	    while ((line = reader.readLine()) != null) {
		sb.append(line + "\n");
	    }
	} catch (IOException e) {
	    LOGGER.error(e.getMessage());
	} finally {
	    try {
		is.close();
	    } catch (IOException e) {
		LOGGER.error(e.getMessage());
	    }
	}
	return sb.toString();
    }
}
