package com.impetus.stockapp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.impetus.stockapp.entity.Investor;
import com.impetus.stockapp.exception.StockApplicationException;
import com.impetus.stockapp.service.LoginService;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class LoginServiceTest {
    private final Logger LOGGER = Logger.getLogger(LoginServiceTest.class);
    
    @Autowired
    private LoginService loginServiceImpl;
    
    /**
     * Method testGetPasswordByEmailIDValue.
     * 
     * @throws StockApplicationException
     */
    @Test
    public void testGetPasswordByEmailIDValue() throws StockApplicationException {
	final String email = "lakhmapurkarvishal@yahoo.com";
	Investor result = loginServiceImpl.getPassword(email);
	if (result != null) {
	    assertNotNull(result);
	} else {
	    assertNull(result);
	}
	Investor result2 = loginServiceImpl.getPassword(null);
	assertNull(result2);
    }
    
    /**
     * Method testAuthenticateInvester.
     * 
     * @throws StockApplicationException
     */
    @Test
    public void testAuthenticateInvester() throws StockApplicationException {
	final String username = "vishal";
	final String password = "vishal";
	Investor result = loginServiceImpl.authenticateUser(username, password);
	if (result != null) {
	    assertNotNull(result);
	} else {
	    assertNull(result);
	}
	Investor result2 = loginServiceImpl.authenticateUser(null, null);
	assertNull(result2);
    }
    
    @Test
    public void testAuthenticateInvester2() throws StockApplicationException {
	
	Investor result2 = loginServiceImpl.authenticateUser(null, null);
	assertNull(result2);
    }
    
    /**
     * Method testUsernameAlreadyExist.
     * 
     * @throws StockApplicationException
     */
    @Test
    public void testUsernameAlreadyExist() throws StockApplicationException {
	final String username = "afwsfwe";
	
	boolean result = loginServiceImpl.isUserNameAlreadyExistInDB(username);
	assertTrue(result);
	boolean result2 = loginServiceImpl.isUserNameAlreadyExistInDB(null);
	assertFalse(result2);
    }
    
}
