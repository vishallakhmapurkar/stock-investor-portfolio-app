package com.impetus.stockapp.service;

import java.util.List;

import com.impetus.stockapp.entity.Stock;
import com.impetus.stockapp.exception.StockApplicationException;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
public interface StockService {
    /**
     * Method searchForStock.
     * @param stockSymbol String
    
    
     * @return List<Stock> * @throws StockApplicationException */
    List<Stock> searchForStock(String stockSymbol)
	    throws StockApplicationException;

    /**
     * Method getLiveStock.
     * @param stockId Long
    
    
     * @return Stock * @throws StockApplicationException */
    Stock getLiveStock(Long stockId) throws StockApplicationException;
}
