package com.impetus.stockapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.text.DateFormat;

import org.junit.Test;

import com.impetus.stockapp.bean.InvestorStock;

/**
 * The class <code>InvesterStockTest</code> contains tests for the class <code>{@link InvestorStock}</code>.
 * 
 * @generatedBy CodePro at 22/9/12 11:31 AM
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
public class InvestorStockBeanTest {
    /**
     * Initialize a newly create test instance to have the given name.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
    
     * @throws Exception */

    /**
     * Run the double getCurrPrice() method test.
     * 
     * @throws Exception
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     */
    @Test
    public void testGetCurrPrice_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);

	double result = fixture.getCurrPrice();

	// add additional test code here
	assertEquals(1.0, result, 0.1);
    }

    /**
     * Run the int getEmailAlert() method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testGetEmailAlert_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);

	int result = fixture.getEmailAlert();

	// add additional test code here
	assertEquals(1, result);
    }

    /**
     * Run the double getFaceValue() method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testGetFaceValue_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);

	double result = fixture.getFaceValue();

	// add additional test code here
	assertEquals(1.0, result, 0.1);
    }

    /**
     * Run the double getInvesterAmountStatus() method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testGetInvesterAmountStatus_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);

	double result = fixture.getInvesterAmountStatus();

	// add additional test code here
	assertEquals(1.0, result, 0.1);
    }

    /**
     * Run the Long getInvesterStockID() method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testGetInvesterStockID_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);

	Long result = fixture.getInvesterStockID();

	// add additional test code here
	assertNotNull(result);
	assertEquals("1", result.toString());
	assertEquals((byte) 1, result.byteValue());
	assertEquals(1.0, result.doubleValue(), 1.0);
	assertEquals(1.0f, result.floatValue(), 1.0f);
	assertEquals(1, result.intValue());
	assertEquals(1L, result.longValue());
	assertEquals((short) 1, result.shortValue());
    }

    /**
     * Run the int getQuantity() method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testGetQuantity_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);

	int result = fixture.getQuantity();

	// add additional test code here
	assertEquals(1, result);
    }

    /**
     * Run the Long getStockID() method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testGetStockID_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);

	Long result = fixture.getStockID();

	// add additional test code here
	assertNotNull(result);
	assertEquals("1", result.toString());
	assertEquals((byte) 1, result.byteValue());
	assertEquals(1.0, result.doubleValue(), 1.0);
	assertEquals(1.0f, result.floatValue(), 1.0f);
	assertEquals(1, result.intValue());
	assertEquals(1L, result.longValue());
	assertEquals((short) 1, result.shortValue());
    }

    /**
     * Run the double getStockPurchasePrice() method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testGetStockPurchasePrice_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);

	double result = fixture.getStockPurchasePrice();

	// add additional test code here
	assertEquals(1.0, result, 0.1);
    }

    /**
     * Run the Date getStockPurchasedate() method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testGetStockPurchasedate_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);

	Date result = fixture.getStockPurchasedate();

	// add additional test code here
	assertNotNull(result);
	assertEquals(DateFormat.getInstance().format(new Date(1L)), DateFormat.getInstance().format(result));
	assertEquals(1L, result.getTime());
    }

    /**
     * Run the String getStockSymbol() method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testGetStockSymbol_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);

	String result = fixture.getStockSymbol();

	// add additional test code here
	assertEquals("", result);
    }

    /**
     * Run the double getVarient() method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testGetVarient_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);

	double result = fixture.getVarient();

	// add additional test code here
	assertEquals(1.0, result, 0.1);
    }

    /**
     * Run the void setCurrPrice(double) method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testSetCurrPrice_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);
	double currPrice = 1.0;

	fixture.setCurrPrice(currPrice);

	// add additional test code here
    }

    /**
     * Run the void setEmailAlert(int) method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testSetEmailAlert_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);
	int emailAlert = 1;

	fixture.setEmailAlert(emailAlert);

	// add additional test code here
    }

    /**
     * Run the void setFaceValue(double) method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testSetFaceValue_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);
	double faceValue = 1.0;

	fixture.setFaceValue(faceValue);

	// add additional test code here
    }

    /**
     * Run the void setInvesterAmountStatus(double) method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testSetInvesterAmountStatus_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);
	double investerAmountStatus = 1.0;

	fixture.setInvesterAmountStatus(investerAmountStatus);

	// add additional test code here
    }

    /**
     * Run the void setInvesterStockID(Long) method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testSetInvesterStockID_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);
	Long investerStockID = new Long(1L);

	fixture.setInvesterStockID(investerStockID);

	// add additional test code here
    }

    /**
     * Run the void setQuantity(int) method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testSetQuantity_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);
	int quantity = 1;

	fixture.setQuantity(quantity);

	// add additional test code here
    }

    /**
     * Run the void setStockID(Long) method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testSetStockID_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);
	Long stockID = new Long(1L);

	fixture.setStockID(stockID);

	// add additional test code here
    }

    /**
     * Run the void setStockPurchasePrice(double) method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testSetStockPurchasePrice_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);
	double stockPurchasePrice = 1.0;

	fixture.setStockPurchasePrice(stockPurchasePrice);

	// add additional test code here
    }

    /**
     * Run the void setStockPurchasedate(Date) method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testSetStockPurchasedate_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);
	Date stockPurchasedate = new Date(1L);

	fixture.setStockPurchasedate(stockPurchasedate);

	// add additional test code here
    }

    /**
     * Run the void setStockSymbol(String) method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testSetStockSymbol_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);
	String stockSymbol = "";

	fixture.setStockSymbol(stockSymbol);

	// add additional test code here
    }

    /**
     * Run the void setVarient(double) method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @throws Exception */
    @Test
    public void testSetVarient_1() throws Exception {
	InvestorStock fixture = new InvestorStock();
	fixture.setCurrPrice(1.0);
	fixture.setStockPurchasePrice(1.0);
	fixture.setVarient(1.0);
	fixture.setStockSymbol("");
	fixture.setInvesterStockID(new Long(1L));
	fixture.setQuantity(1);
	fixture.setEmailAlert(1);
	fixture.setStockPurchasedate(new Date(1L));
	fixture.setStockID(new Long(1L));
	fixture.setInvesterAmountStatus(1.0);
	fixture.setFaceValue(1.0);
	double varient = 1.0;

	fixture.setVarient(varient);

	// add additional test code here
    }

    /**
     * Run the String toString() method test.
     * 
    
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     * @param args String[]
     * @throws Exception */
   

    /**
     * Launch the test.
     * 
     * @param args
     *            the command line arguments
     * 
     * @generatedBy CodePro at 22/9/12 11:31 AM
     */
    public static void main(final String[] args) {
	new org.junit.runner.JUnitCore().run(InvestorStockBeanTest.class);
    }
}