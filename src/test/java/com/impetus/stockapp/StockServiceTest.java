package com.impetus.stockapp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.impetus.stockapp.entity.Stock;
import com.impetus.stockapp.exception.StockApplicationException;
import com.impetus.stockapp.service.StockService;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class StockServiceTest {
    @Autowired
    private StockService stockServiceImpl;

    /**
     * Method testSearchForStock.
    
     * @throws StockApplicationException */
    @Test
    public void testSearchForStock() throws StockApplicationException {
	List<Stock> stocks = stockServiceImpl.searchForStock("AA");
	assertTrue(stocks.size() > 0);
	List<Stock> stocks2 = stockServiceImpl.searchForStock("78");
	assertTrue(stocks2.size() == 0);
    }

    /**
     * Method testLiveStock.
    
     * @throws StockApplicationException */
    @Test
    public void testLiveStock() throws StockApplicationException {
	Stock stock = stockServiceImpl.getLiveStock(1L);
	assertNotNull(stock);
	Stock stock1 = stockServiceImpl.getLiveStock(0L);
	assertNull(stock1);

    }
}
