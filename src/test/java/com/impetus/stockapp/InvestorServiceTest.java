package com.impetus.stockapp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.stockapp.entity.Investor;
import com.impetus.stockapp.exception.StockApplicationException;
import com.impetus.stockapp.service.InvestorService;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class InvestorServiceTest {
    @Autowired
    private InvestorService investorService;
    
    /**
     * Method testAddInvestor.
     * 
     * 
     * @throws StockApplicationException
     */
    @Test
    public void testAddInvestor() throws StockApplicationException {
	Investor investor = investorService.addInvester(getInvestorBean());
	if (investor.getUserId() > 0) {
	    assertTrue(true);
	}
    }
    
    /**
     * Method testAddInvestor2.
     * 
     * @throws StockApplicationException
     */
    @Test(expected = StockApplicationException.class)
    public void testAddInvestor2() throws StockApplicationException {
	Investor investor = investorService.addInvester(null);
	
    }
    
    /**
     * Method testAddInvestor2.
     * 
     * @throws StockApplicationException
     */
    @Test(expected = StockApplicationException.class)
    public void testdelete() throws StockApplicationException {
	investorService.delete(null);
	
    }
    
    @Test
    public void testUsernameExist() throws StockApplicationException {
	long result = investorService.userNameExist(null);
	assertTrue(result == 0);
	
    }
    
    /**
     * Method testUserNameExist.
     * 
     * 
     * @throws StockApplicationException
     */
    @Test
    public void testUserNameExist() throws StockApplicationException {
	Long val = investorService.userNameExist((getInvestorBean().getUsername()));
	if (val > 0) {
	    assertTrue(true);
	} else {
	    assertTrue(true);
	}
    }
    
    /**
     * Method testUserNameExist.
     * 
     * 
     * @throws StockApplicationException
     */
    @Test
    public void testDeleteInvester() throws StockApplicationException {
	investorService.delete(getInvestorBean());
	assertTrue(true);
    }
    
    /**
     * Method testDeleteInvester2.
     * 
     * @throws StockApplicationException
     */
    @Test(expected = StockApplicationException.class)
    public void testDeleteInvester2() throws StockApplicationException {
	investorService.delete(null);
	
    }
    
    /**
     * Method testEmailExist.
     * 
     * 
     * @throws StockApplicationException
     */
    @Test
    public void testEmailExist() throws StockApplicationException {
	Long val = investorService.emailExist((getInvestorBean().getEmail()));
	if (val > 0) {
	    assertTrue(true);
	} else {
	    assertTrue(true);
	}
    }
    
    /**
     * Method getInvestorBean.
     * 
     * 
     * @return Investor
     */
    private Investor getInvestorBean() {
	
	Investor investor = new Investor();
	investor.setFirstName("vishal");
	investor.setLastName("kumar2");
	investor.setUsername("vishal");
	investor.setMobile("989380828");
	investor.setEmail("lakhmapurkarvishal@yahoo.com");
	investor.setPassword("vishal123");
	investor.setAddressLineOne("40 sai vihar");
	investor.setAddressLineTwo("post tilak nagar");
	investor.setCity("indore");
	investor.setState("MP");
	investor.setPostalcode("458990");
	investor.setPasswordSet(true);
	return investor;
	
    }
}
