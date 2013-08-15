package com.impetus.stockapp.service;

import java.sql.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.stockapp.entity.InvestorStocksDetails;
import com.impetus.stockapp.repository.InvesterStocksRepository;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@Service
public class InvestorStocksServiceImpl implements InvestorStocksService {
    private static Logger	    LOGGER = Logger.getLogger(InvestorStocksServiceImpl.class);
    @Autowired
    private InvesterStocksRepository investerStocksRepository;

    /**
     * Method deleteStock.
     * @param stockId Long
    
    
     * @return boolean * @see com.impetus.stockapp.service.InvestorStocksService#deleteStock(Long) */
    @Transactional
    @Override
    public boolean deleteStock(final Long stockId) {
	try {
	    investerStocksRepository.delete(stockId);
	    return true;
	} catch (DataAccessException e) {
	    LOGGER.error("stock id invalid", e);
	    return false;
	}

    }

    /**
     * Method addOrUpdateStock.
     * @param investorStocksDetails InvestorStocksDetails
    
    
     * @return InvestorStocksDetails * @see com.impetus.stockapp.service.InvestorStocksService#addOrUpdateStock(InvestorStocksDetails) */
    @Transactional
    @Override
    public InvestorStocksDetails addOrUpdateStock(final InvestorStocksDetails investorStocksDetails) {
	if (investorStocksDetails == null) {
	    return null;
	} else {
	    return investerStocksRepository.save(investorStocksDetails);
	}
    }

    /**
     * Method resetEmailAlert.
     * @param variant Long
     * @param emailAlert int
     * @param investerstockID Long
    
    
     * @return int * @see com.impetus.stockapp.service.InvestorStocksService#resetEmailAlert(Long, int, Long) */
    @Transactional
    @Override
    public int resetEmailAlert(final Long variant, final int emailAlert, final Long investerstockID) {
	if ((investerStocksRepository != null) && ((emailAlert == 0) || (emailAlert == 1)) && (variant <= 20)) {
	    return investerStocksRepository.resetEmailAlert(variant, emailAlert, investerstockID);
	} else {
	    return 0;
	}
    }

    /**
     * Method updateInvesterSTock.
     * @param quantity int
     * @param purchaseDate Date
     * @param purchaseprice double
     * @param investerstockID Long
    
    
     * @return int * @see com.impetus.stockapp.service.InvestorStocksService#updateInvesterSTock(int, Date, double, Long) */
    @Transactional
    @Override
    public int updateInvesterSTock(final int quantity, final Date purchaseDate, final double purchaseprice,
	    final Long investerstockID) {
	if ((investerStocksRepository != null) && (quantity >= 0) && (purchaseDate != null) && (purchaseprice >= 0.0)) {
	    return investerStocksRepository.updateInvesterSTock(quantity, purchaseDate, purchaseprice, investerstockID);
	} else {
	    return 0;
	}
    }

}
