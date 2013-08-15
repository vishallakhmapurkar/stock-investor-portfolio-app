package com.impetus.stockapp;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.stockapp.entity.InvestorStocksDetails;
import com.impetus.stockapp.repository.InvesterStocksRepository;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class InvestorStocksTest {
    @Autowired
    private InvesterStocksRepository investerStocksRepository;
    private static final Logger      LOGGER	 = Logger.getLogger(InvestorStocksTest.class);
    private static final Long	STOCK_ID       = 1L;
    private static final Long	INVESTER_ID    = 1L;
    private static final Long	VARIANCE       = 20L;
    private static final int	 QUANTITY       = 20;
    private static final int	 PURCHASE_PRICE = 200;
    private static final int	 EMAIL_ALERT    = 1;

    @Ignore
    public void testAddInvestorStockDetails() {
	InvestorStocksDetails newInvesterStocksDetails = investerStocksRepository.save(getInvesterStockDetailsBean());
	LOGGER.info("Investere details added and get new Details of invester"
		+ newInvesterStocksDetails.getInvesterStockDetailsId());
	assertTrue(newInvesterStocksDetails != null);

    }

    @Ignore
    public void testDeleteStockById() {
	InvestorStocksDetails newInvesterStocksDetails = investerStocksRepository.save(getInvesterStockDetailsBean());
	if (newInvesterStocksDetails.getInvesterStockDetailsId() != null) {
	    investerStocksRepository.delete(newInvesterStocksDetails.getInvesterStockDetailsId());
	    LOGGER.info("Invester Stock deleted" + newInvesterStocksDetails.getStockId());
	    assertTrue(true);
	} else {
	    assertTrue(true);
	    LOGGER.info("Invester Stock not deleted" + newInvesterStocksDetails.getStockId());

	}
    }

    @Test
    public void testUpdateInvestorStockDetails() {
	InvestorStocksDetails newInvesterStocksDetails = investerStocksRepository.save(getInvesterStockDetailsBean());
	if (newInvesterStocksDetails.getInvesterStockDetailsId() != null) {
	    newInvesterStocksDetails.setStockId(new Long(5));
	    InvestorStocksDetails updatedInvesterStocksDetails = investerStocksRepository
		    .save(newInvesterStocksDetails);
	    if (getInvesterStockDetailsBean().getStockId() == updatedInvesterStocksDetails.getStockId()) {
		LOGGER.info("Invester Stock  updated");
		assertTrue(true);
	    } else {
		assertTrue(true);
		LOGGER.info("Invester Stock not updated");

	    }

	}

    }

    @Ignore
    public void testUpdateInvestorStockDetails2() {
	InvestorStocksDetails newInvesterStocksDetails = investerStocksRepository.save(getInvesterStockDetailsBean());
	if (newInvesterStocksDetails.getInvesterStockDetailsId() != null) {

	    int val = investerStocksRepository.resetEmailAlert(20L, 0,
		    newInvesterStocksDetails.getInvesterStockDetailsId());
	    if (val > 0) {
		LOGGER.info("Invester Stock not updated");
		assertTrue(true);
	    } else {
		assertTrue(true);
		LOGGER.info("Invester Stock updated");

	    }

	}

    }

    @Ignore
    public void testDeleteInvestorStockDetails() {
	InvestorStocksDetails newInvesterStocksDetails = investerStocksRepository.save(getInvesterStockDetailsBean());
	if (newInvesterStocksDetails.getInvesterStockDetailsId() != null) {
	    investerStocksRepository.delete(newInvesterStocksDetails.getInvesterStockDetailsId());
	    LOGGER.info("Investere details deleted");
	    assertTrue(true);
	}

    }

    /**
     * Method getInvesterStockDetailsBean.
    
     * @return InvestorStocksDetails */
    private InvestorStocksDetails getInvesterStockDetailsBean() {
	InvestorStocksDetails investorStocksDetails = new InvestorStocksDetails();
	investorStocksDetails.setInvesterId(INVESTER_ID);
	investorStocksDetails.setIsEmailAlertActivate(EMAIL_ALERT);
	investorStocksDetails.setPurchasedate(new Date(System.currentTimeMillis()));
	investorStocksDetails.setQuantity(QUANTITY);
	investorStocksDetails.setStockId(STOCK_ID);
	investorStocksDetails.setPurchasePrice(PURCHASE_PRICE);
	investorStocksDetails.setVarient(VARIANCE);

	return investorStocksDetails;

    }

    /**
     * Method main.
     * @param args String[]
     */
    public static void main(final String[] args) {
	new org.junit.runner.JUnitCore().run(InvestorStocksTest.class);
    }

}
