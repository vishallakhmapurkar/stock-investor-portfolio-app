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
@Table(name = "stock_price_yearly_tbl", catalog = "stockinvestorapp")
public class StockYearDetail {
    @Id
    @GeneratedValue
    @Column(name = "stock_price_yearly_id")
    private Long   stockPriceId;
    @Column(name = "stock_id")
    private Long   stockId;
    @Column(name = "stock_entry_date")
    private Date   stockEntryDate;
    private double price;

    /**
     * Method getPrice.
    
     * @return double */
    public double getPrice() {
	return price;
    }

    /**
     * Method setPrice.
     * @param price double
     */
    public void setPrice(final double price) {
	this.price = price;
    }

    /**
     * Method getStockPriceId.
    
     * @return Long */
    public Long getStockPriceId() {
	return stockPriceId;
    }

    /**
     * Method setStockPriceId.
     * @param stockPriceId Long
     */
    public void setStockPriceId(final Long stockPriceId) {
	this.stockPriceId = stockPriceId;
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
     * Method getStockEntryDate.
    
     * @return Date */
    public Date getStockEntryDate() {
	return stockEntryDate;
    }

    /**
     * Method setStockEntryDate.
     * @param stockEntryDate Date
     */
    public void setStockEntryDate(final Date stockEntryDate) {
	this.stockEntryDate = stockEntryDate;
    }

}
