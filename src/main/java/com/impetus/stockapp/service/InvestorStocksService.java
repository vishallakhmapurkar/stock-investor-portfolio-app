package com.impetus.stockapp.service;

import java.sql.Date;

import com.impetus.stockapp.entity.InvestorStocksDetails;
import com.impetus.stockapp.exception.StockApplicationException;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
public interface InvestorStocksService {
    /**
     * Method deleteStock.
     * @param stockId Long
    
    
     * @return boolean * @throws StockApplicationException */
    boolean deleteStock(Long stockId) throws StockApplicationException;

    /**
     * Method addOrUpdateStock.
     * @param investorStocksDetails InvestorStocksDetails
    
    
     * @return InvestorStocksDetails * @throws StockApplicationException */
    InvestorStocksDetails addOrUpdateStock(
	    InvestorStocksDetails investorStocksDetails)
	    throws StockApplicationException;

    /**
     * Method resetEmailAlert.
     * @param variant Long
     * @param emailAlert int
     * @param investerstockID Long
    
    
     * @return int * @throws StockApplicationException */
    int resetEmailAlert(Long variant, int emailAlert, Long investerstockID)
	    throws StockApplicationException;

    /**
     * Method updateInvesterSTock.
     * @param quantity int
     * @param purchaseDate Date
     * @param purchaseprice double
     * @param investerstockID Long
    
    
     * @return int * @throws StockApplicationException */
    public int updateInvesterSTock(int quantity, Date purchaseDate,
	    double purchaseprice, Long investerstockID)
	    throws StockApplicationException;
}
