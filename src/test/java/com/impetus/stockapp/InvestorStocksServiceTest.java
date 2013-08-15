package com.impetus.stockapp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.stockapp.entity.InvestorStocksDetails;
import com.impetus.stockapp.exception.StockApplicationException;
import com.impetus.stockapp.service.InvestorStocksService;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class InvestorStocksServiceTest {
    @Autowired
    private InvestorStocksService inverteerStocksServiceImpl;
    
    /**
     * Method testDeleteStockByID.
     * 
     * @throws StockApplicationException
     */
    @Test
    public void testDeleteStockByID() throws StockApplicationException {
	long stockID = 0;
	boolean result = inverteerStocksServiceImpl.deleteStock(stockID);
	assertNotNull(result);
	boolean result1 = inverteerStocksServiceImpl.deleteStock(null);
	assertFalse(result1);
    }
    
    /**
     * Method testAddInvesterStock.
     * 
     * @throws StockApplicationException
     */
    @Test
    public void testAddInvesterStock() throws StockApplicationException {
	
	InvestorStocksDetails result = inverteerStocksServiceImpl.addOrUpdateStock(getInvesterStocksDetails());
	
	assertNotNull(result);
	InvestorStocksDetails result1 = inverteerStocksServiceImpl.addOrUpdateStock(null);
	assertNull(result1);
    }
    
    /**
     * Method testResetEmailAlert.
     * 
     * @throws StockApplicationException
     */
    @Test
    public void testResetEmailAlert() throws StockApplicationException {
	
	int result = inverteerStocksServiceImpl.resetEmailAlert(10L, 0, 1L);
	
	assertNotNull(result);
	int result1 = inverteerStocksServiceImpl.resetEmailAlert(null, 12, 23L);
	assertNotNull(result1);
    }
    
    /**
     * Method testUpdateInvesterStock.
     * 
     * @throws StockApplicationException
     */
    @Test
    public void testUpdateInvesterStock() throws StockApplicationException {
	
	int result = inverteerStocksServiceImpl.updateInvesterSTock(10, new Date(System.currentTimeMillis()), 200, 1L);
	
	assertNotNull(result);
	int result1 = inverteerStocksServiceImpl.updateInvesterSTock(0, null, 0.0, null);
	assertNotNull(result1);
    }
    
    /**
     * Method getInvesterStocksDetails.
     * 
     * @return InvestorStocksDetails
     */
    private InvestorStocksDetails getInvesterStocksDetails() {
	InvestorStocksDetails investorStocksDetails = new InvestorStocksDetails();
	investorStocksDetails.setInvesterId(1L);
	investorStocksDetails.setIsEmailAlertActivate(1);
	investorStocksDetails.setPurchasedate(new Date(System.currentTimeMillis()));
	investorStocksDetails.setPurchasePrice(200);
	investorStocksDetails.setQuantity(20);
	investorStocksDetails.setStockId(1L);
	investorStocksDetails.setVarient(20L);
	return investorStocksDetails;
    }
}
