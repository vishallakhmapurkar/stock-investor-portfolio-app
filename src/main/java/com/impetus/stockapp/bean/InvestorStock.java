package com.impetus.stockapp.bean;

import java.sql.Date;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
public class InvestorStock {
    private String stockSymbol;
    private String companyName;
    private Long   stockID;
    private double stockPurchasePrice;
    private double varient;
    private int    emailAlert;
    private int    quantity;
    private double currPrice;
    private double investerAmountStatus;
    private double faceValue;
    private Date   stockPurchasedate;
    private Long   investerStockID;

    /**
     * Method getCompanyName.
    
     * @return String */
    public String getCompanyName() {
		return companyName;
	}

	/**
	 * Method setCompanyName.
	 * @param companyName String
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * Method getInvesterStockID.
	
	 * @return Long */
	public Long getInvesterStockID() {
	return investerStockID;
    }

    /**
     * Method setInvesterStockID.
     * @param investerStockID Long
     */
    public void setInvesterStockID(final Long investerStockID) {
	this.investerStockID = investerStockID;
    }

    /**
     * Method getStockPurchasedate.
    
     * @return Date */
    public Date getStockPurchasedate() {
	return stockPurchasedate;
    }

    /**
     * Method setStockPurchasedate.
     * @param stockPurchasedate Date
     */
    public void setStockPurchasedate(final Date stockPurchasedate) {
	this.stockPurchasedate = stockPurchasedate;
    }

    /**
     * Method getFaceValue.
    
     * @return double */
    public double getFaceValue() {
	return faceValue;
    }

    /**
     * Method setFaceValue.
     * @param faceValue double
     */
    public void setFaceValue(final double faceValue) {
	this.faceValue = faceValue;
    }

    // private double totalInvestAmount;
    /**
     * Method getStockSymbol.
    
     * @return String */
    public String getStockSymbol() {
	return stockSymbol;
    }

    /**
     * Method setStockSymbol.
     * @param stockSymbol String
     */
    public void setStockSymbol(final String stockSymbol) {
	this.stockSymbol = stockSymbol;
    }

    /**
     * Method getStockID.
    
     * @return Long */
    public Long getStockID() {
	return stockID;
    }

    /**
     * Method setStockID.
     * @param stockID Long
     */
    public void setStockID(final Long stockID) {
	this.stockID = stockID;
    }

    /**
     * Method getStockPurchasePrice.
    
     * @return double */
    public double getStockPurchasePrice() {
	return stockPurchasePrice;
    }

    /**
     * Method setStockPurchasePrice.
     * @param stockPurchasePrice double
     */
    public void setStockPurchasePrice(final double stockPurchasePrice) {
	this.stockPurchasePrice = stockPurchasePrice;
    }

    /**
     * Method getVarient.
    
     * @return double */
    public double getVarient() {
	return varient;
    }

    /**
     * Method setVarient.
     * @param varient double
     */
    public void setVarient(final double varient) {
	this.varient = varient;
    }

    /**
     * Method getEmailAlert.
    
     * @return int */
    public int getEmailAlert() {
	return emailAlert;
    }

    /**
     * Method setEmailAlert.
     * @param emailAlert int
     */
    public void setEmailAlert(final int emailAlert) {
	this.emailAlert = emailAlert;
    }

    /**
     * Method getQuantity.
    
     * @return int */
    public int getQuantity() {
	return quantity;
    }

    /**
     * Method setQuantity.
     * @param quantity int
     */
    public void setQuantity(final int quantity) {
	this.quantity = quantity;
    }

    /**
     * Method getCurrPrice.
    
     * @return double */
    public double getCurrPrice() {
	return currPrice;
    }

    /**
     * Method setCurrPrice.
     * @param currPrice double
     */
    public void setCurrPrice(final double currPrice) {
	this.currPrice = currPrice;
    }

    /**
     * Method getInvesterAmountStatus.
    
     * @return double */
    public double getInvesterAmountStatus() {
	return investerAmountStatus;
    }

    /**
     * Method setInvesterAmountStatus.
     * @param investerAmountStatus double
     */
    public void setInvesterAmountStatus(final double investerAmountStatus) {
	this.investerAmountStatus = investerAmountStatus;
    }

    /**
     * Method toString.
    
     * @return String */
    @Override
	public String toString() {
		return "InvestorStock [stockSymbol=" + stockSymbol + ", companyName="
				+ companyName + ", stockID=" + stockID
				+ ", stockPurchasePrice=" + stockPurchasePrice + ", varient="
				+ varient + ", emailAlert=" + emailAlert + ", quantity="
				+ quantity + ", currPrice=" + currPrice
				+ ", investerAmountStatus=" + investerAmountStatus
				+ ", faceValue=" + faceValue + ", stockPurchasedate="
				+ stockPurchasedate + ", investerStockID=" + investerStockID
				+ "]";
	}

}
