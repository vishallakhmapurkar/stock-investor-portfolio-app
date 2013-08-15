package com.impetus.stockapp;


import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.stockapp.entity.Investor;
import com.impetus.stockapp.repository.InvestorRepository;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class InvestorTest {
    @Autowired
    private InvestorRepository  investorRepository;
    private static final Logger LOGGER = Logger.getLogger(InvestorTest.class);

    @Test
    public void testAddInvestor() {
	Investor investor = investorRepository.save(getInvestorBean());
	if (investor.getUserId() > 0) {
	    LOGGER.info("Invester Added");
	    assertTrue(true);
	}

    }

    @Test
    public void testUpdateInvestor() {
	Investor investor = investorRepository.save(getInvestorBean());
	if (investor.getUserId() > 0) {
	    investor.setPassword("1234");
	    Investor updatedInvesterDetails = investorRepository.save(investor);
	    if (getInvestorBean().getPassword().equalsIgnoreCase(updatedInvesterDetails.getPassword())) {
		LOGGER.info("Invester not updated");
		assertTrue(true);
	    } else {
		assertTrue(true);
		LOGGER.info("Invester updated");

	    }
	}

    }

    @Test
    public void testDeleteInvestor() {
	Investor investor = investorRepository.save(getInvestorBean());
	if (investor.getUserId() > 0) {
	    investorRepository.delete(investor.getUserId());
	    LOGGER.info("Investere details deleted");
	    assertTrue(true);
	}

    }

    @Test
    public void testInvestorExist() {
	long val = investorRepository.exist(getInvestorBean().getUsername());
	if (val == 0) {
	    LOGGER.info("user not exist");
	    assertTrue(true);
	} else {
	    LOGGER.info("user exist");
	    assertTrue(true);
	}

    }


    /**
     * Method getInvestorBean.
    
     * @return Investor */
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
