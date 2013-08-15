package com.impetus.stockapp.service;

import com.impetus.stockapp.entity.Investor;
import com.impetus.stockapp.exception.StockApplicationException;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
public interface LoginService {
    /**
     * Method authenticateUser.
     * @param username String
     * @param password String
    
    
     * @return Investor * @throws StockApplicationException */
    Investor authenticateUser(String username, String password)
	    throws StockApplicationException;

    /**
     * Method isUserNameAlreadyExistInDB.
     * @param username String
    
    
     * @return boolean * @throws StockApplicationException */
    boolean isUserNameAlreadyExistInDB(String username)
	    throws StockApplicationException;

    /**
     * Method getPassword.
     * @param email String
    
    
     * @return Investor * @throws StockApplicationException */
    Investor getPassword(String email) throws StockApplicationException;
}
