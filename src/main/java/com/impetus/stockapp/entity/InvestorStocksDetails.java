package com.impetus.stockapp.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@Entity
@Table(name = "invester_stocks_details_tbl", catalog = "stockinvestorapp")
public class InvestorStocksDetails {
    @Id
    @GeneratedValue
    @Column(name = "invester_stock_details_id")
    private Long   investerStockDetailsId;
    @Column(name = "stock_id")
    private Long   stockId;
    @Column(name = "invester_id")
    private Long   investerId;
    private int    quantity;
    @Column(name = "stock_purchase_price")
    private double purchasePrice;
    private Long   varient;
    @Column(name = "stock_purchase_date")
    private Date   purchasedate;

    private int    isEmailAlertActivate;

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
     * Method getPurchasePrice.
    
     * @return double */
    public double getPurchasePrice() {
	return purchasePrice;
    }

    /**
     * Method setPurchasePrice.
     * @param purchasePrice double
     */
    public void setPurchasePrice(final double purchasePrice) {
	this.purchasePrice = purchasePrice;
    }

    /**
     * Method getPurchasedate.
    
     * @return Date */
    public Date getPurchasedate() {
	return purchasedate;
    }

    /**
     * Method setPurchasedate.
     * @param purchasedate Date
     */
    public void setPurchasedate(final Date purchasedate) {
	this.purchasedate = purchasedate;
    }

    /**
     * Method getInvesterStockDetailsId.
    
     * @return Long */
    public Long getInvesterStockDetailsId() {
	return investerStockDetailsId;
    }

    /**
     * Method setInvesterStockDetailsId.
     * @param investerStockDetailsId Long
     */
    public void setInvesterStockDetailsId(final Long investerStockDetailsId) {
	this.investerStockDetailsId = investerStockDetailsId;
    }

    /**
     * Method getStockId.
    
     * @return Long */
    public Long getStockId() {
	return stockId;
    }

    /**
     * Method setStockId.
     * @param stockId Long
     */
    public void setStockId(final Long stockId) {
	this.stockId = stockId;
    }

    /**
     * Method getInvesterId.
    
     * @return Long */
    public Long getInvesterId() {
	return investerId;
    }

    /**
     * Method setInvesterId.
     * @param investerId Long
     */
    public void setInvesterId(final Long investerId) {
	this.investerId = investerId;
    }

    /**
     * Method getVarient.
    
     * @return Long */
    public Long getVarient() {
	return varient;
    }

    /**
     * Method setVarient.
     * @param varient Long
     */
    public void setVarient(final Long varient) {
	this.varient = varient;
    }

    /**
     * Method getIsEmailAlertActivate.
    
     * @return int */
    public int getIsEmailAlertActivate() {
	return isEmailAlertActivate;
    }

    /**
     * Method setIsEmailAlertActivate.
     * @param isEmailAlertActivate int
     */
    public void setIsEmailAlertActivate(final int isEmailAlertActivate) {
	this.isEmailAlertActivate = isEmailAlertActivate;
    }

}
