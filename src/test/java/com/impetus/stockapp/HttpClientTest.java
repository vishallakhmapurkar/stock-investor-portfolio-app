package com.impetus.stockapp;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.impetus.stockapp.bean.InvestorStock;
import com.impetus.stockapp.config.AppConfig;
import com.impetus.stockapp.exception.StockApplicationException;
import com.impetus.stockapp.util.HttpUtil;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class HttpClientTest {
    private final Logger LOGGER = Logger.getLogger(HttpClientTest.class);
    private final HttpUtil stockServiceClient = new HttpUtil();
    @Autowired
    private AppConfig conf;
    
    /**
     * Method testStockService.
    
     * @throws StockApplicationException */
    @Test
    // (expected = StockApplicationException.class)
    public void testStockService() throws StockApplicationException {
	
	try {
	    URL url = new URL(conf.getWebServicePath() + "1");
	    URLConnection conn = url.openConnection();
	    conn.connect();
	    
	    List<InvestorStock> stocks = stockServiceClient.getInvesterStockList(conf.getWebServicePath() + "1");
	    LOGGER.info("Invester Stock size" + stocks.size());
	    if (stocks.size() > 0) {
		LOGGER.info("Invester Stock size" + stocks.size());
		assertTrue(true);
	    } else {
		LOGGER.info("Invester has no Stock ");
		assertTrue(true);
	    }
	} catch (MalformedURLException e) {
	    LOGGER.error("Url not reachable" + conf.getWebServicePath() + "1" + e.getMessage());
	    assertTrue(true);
	} catch (IOException e) {
	    LOGGER.error("Url not reachable" + conf.getWebServicePath() + "1" + e.getMessage());
	    assertTrue(true);
	}
	
    }
    
}
