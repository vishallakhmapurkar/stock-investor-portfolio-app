package com.impetus.stockapp.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_price_per_day_tbl", catalog = "stockinvestorapp")
public class StockPerDayDetail {
    @Id
    @GeneratedValue
    @Column(name = "stock_price_per_day_id")
    private Long      stockPriceId;
    @Column(name = "stock_id")
    private Long      stockId;
    @Column(name = "day_time")
    private Timestamp daytime;
    private double    price;
    @Column(name = "entry_date")
    private Date      entryDate;
    
    public Long getStockPriceId() {
	return stockPriceId;
    }
    
    public void setStockPriceId(final Long stockPriceId) {
	this.stockPriceId = stockPriceId;
    }
    
    public Long getStockId() {
	return stockId;
    }
    
    public void setStockId(final Long stockId) {
	this.stockId = stockId;
    }
    
    public Timestamp getDaytime() {
	return daytime;
    }
    
    public void setDaytime(final Timestamp daytime) {
	this.daytime = daytime;
    }
    
    public double getPrice() {
	return price;
    }
    
    public void setPrice(final double price) {
	this.price = price;
    }
    
    public Date getEntryDate() {
	return entryDate;
    }
    
    public void setEntryDate(Date entryDate) {
	this.entryDate = entryDate;
    }
    
}
