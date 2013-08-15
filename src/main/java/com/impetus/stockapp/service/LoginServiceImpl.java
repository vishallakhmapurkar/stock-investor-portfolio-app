package com.impetus.stockapp.service;

import org.apache.commons.validator.GenericValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.impetus.stockapp.entity.Investor;
import com.impetus.stockapp.exception.StockApplicationException;
import com.impetus.stockapp.repository.InvestorRepository;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private InvestorRepository investorRepository;
    private static Logger      LOGGER = Logger.getLogger(LoginServiceImpl.class);

    /**
     * Method authenticateUser.
     * @param username String
     * @param password String
    
    
    
     * @return Investor * @throws StockApplicationException * @see com.impetus.stockapp.service.LoginService#authenticateUser(String, String) */
    @Override
    public Investor authenticateUser(final String username, final String password) throws StockApplicationException {
	if (GenericValidator.isBlankOrNull(username) || GenericValidator.isBlankOrNull(password)) {
	    LOGGER.debug("User name or password are blank");

	    return null;
	} else {
	    try {
		return investorRepository.findByUsernameAndPassword(username, password);
	    } catch (DataAccessException e) {
		throw new StockApplicationException("Database server down please try after sometime.", e);

	    }
	}

    }

    /**
     * Method isUserNameAlreadyExistInDB.
     * @param username String
    
    
    
     * @return boolean * @throws StockApplicationException * @see com.impetus.stockapp.service.LoginService#isUserNameAlreadyExistInDB(String) */
    @Override
    public boolean isUserNameAlreadyExistInDB(final String username) throws StockApplicationException {
	if (GenericValidator.isBlankOrNull(username)) {
	    LOGGER.debug("User name  is blank");
	    return false;
	} else {
	    try {
		long val = investorRepository.exist(username);
		return (val == 0);
	    } catch (Exception e) {
		throw new StockApplicationException("Database server down please try after sometime.", e);

	    }
	}

    }

    /**
     * Method getPassword.
     * @param email String
    
    
    
     * @return Investor * @throws StockApplicationException * @see com.impetus.stockapp.service.LoginService#getPassword(String) */
    @Override
    public Investor getPassword(final String email) throws StockApplicationException {
	if (GenericValidator.isBlankOrNull(email)) {
	    LOGGER.debug("email is  blank");
	    return null;
	} else {
	    try {
		return investorRepository.getPassword(email);
	    } catch (DataAccessException e) {
		throw new StockApplicationException("Database server down please try after sometime.", e);

	    }
	}

    }

}
