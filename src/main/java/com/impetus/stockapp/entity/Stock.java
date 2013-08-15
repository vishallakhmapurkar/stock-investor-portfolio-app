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
@Table(name = "stock_master_tbl", catalog = "stockinvestorapp")
public class Stock {
    @Id
    @GeneratedValue
    @Column(name = "stock_id")
    private Long   stockId;
    @Column(name = "stock_symbol")
    private String stockSymbol;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "entry_date")
    private Date   entryDate;
    @Column(name = "face_value")
    private long   faceValue;

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
     * Method getCompanyName.
    
     * @return String */
    public String getCompanyName() {
	return companyName;
    }

    /**
     * Method setCompanyName.
     * @param companyName String
     */
    public void setCompanyName(final String companyName) {
	this.companyName = companyName;
    }

    /**
     * Method getEntryDate.
    
     * @return Date */
    public Date getEntryDate() {
	return entryDate;
    }

    /**
     * Method setEntryDate.
     * @param entryDate Date
     */
    public void setEntryDate(final Date entryDate) {
	this.entryDate = entryDate;
    }

    /**
     * Method getFaceValue.
    
     * @return long */
    public long getFaceValue() {
	return faceValue;
    }

    /**
     * Method setFaceValue.
     * @param faceValue long
     */
    public void setFaceValue(final long faceValue) {
	this.faceValue = faceValue;
    }

    /**
     * Method toString.
    
     * @return String */
    @Override
    public String toString() {
	return "Stock [stockId=" + stockId + ", stockSymbol=" + stockSymbol + ", companyName=" + companyName
	        + ", entryDate=" + entryDate + ", faceValue=" + faceValue + "]";
    }

}
