package com.impetus.stockapp.service;

import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.stockapp.entity.Investor;
import com.impetus.stockapp.exception.StockApplicationException;
import com.impetus.stockapp.repository.InvestorRepository;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@Service
public class InvestorServiceImpl implements InvestorService {

    @Autowired
    InvestorRepository investorRepository;

    /**
     * Method addInvester.
     * 
     * @param newInvestor
     *            Investor
    
    
    
     * @return Investor * @throws StockApplicationException * @see com.impetus.stockapp.service.InvestorService#addInvester(Investor) */
    @Transactional
    public Investor addInvester(final Investor newInvestor) throws StockApplicationException {
	try {
	    return investorRepository.save(newInvestor);
	} catch (RuntimeException e) {
	    throw new StockApplicationException("Database server down please try after sometime.", e);
	}
    }

    /**
     * Method userNameExist.
     * 
     * @param username
     *            String
    
    
    
     * @return Long * @throws StockApplicationException * @see com.impetus.stockapp.service.InvestorService#userNameExist(String) */
    @Override
    public Long userNameExist(final String username) throws StockApplicationException {
	if (GenericValidator.isBlankOrNull(username)) {
	    return 0L;
	} else {
	    try {
		return investorRepository.exist(username);
	    } catch (RuntimeException e) {
		throw new StockApplicationException("Database server down please try after sometime.", e);
	    }
	}
    }

    /**
     * Method emailExist.
     * 
     * @param email
     *            String
    
    
    
     * @return Long * @throws StockApplicationException * @see com.impetus.stockapp.service.InvestorService#emailExist(String) */
    @Override
    public Long emailExist(final String email) throws StockApplicationException {
	try {
	    return investorRepository.emailIdExist(email);
	} catch (RuntimeException e) {
	    throw new StockApplicationException("Database server down please try after sometime.", e);
	}
    }

    /**
     * Method delete.
     * 
     * @param newInvestor
     *            Investor
    
    
     * @throws StockApplicationException * @see com.impetus.stockapp.service.InvestorService#delete(Investor) */
    @Override
    public void delete(Investor newInvestor) throws StockApplicationException {
	try {
	    investorRepository.delete(newInvestor);
	} catch (RuntimeException e) {
	    throw new StockApplicationException("Database server down please try after sometime.", e);
	}
    }
}
