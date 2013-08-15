package com.impetus.stockapp.service;

import com.impetus.stockapp.entity.Investor;
import com.impetus.stockapp.exception.StockApplicationException;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
public interface InvestorService {
    /**
     * Method addInvester.
     * @param newInvestor Investor
    
    
     * @return Investor * @throws StockApplicationException */
    Investor addInvester(Investor newInvestor) throws StockApplicationException;

    /**
     * Method userNameExist.
     * @param username String
    
    
     * @return Long * @throws StockApplicationException */
    Long userNameExist(String username) throws StockApplicationException;

    /**
     * Method emailExist.
     * @param email String
    
    
     * @return Long * @throws StockApplicationException */
    Long emailExist(String email) throws StockApplicationException;

    /**
     * Method delete.
     * @param newInvestor Investor
    
     * @throws StockApplicationException */
    void delete(Investor newInvestor) throws StockApplicationException;
}
