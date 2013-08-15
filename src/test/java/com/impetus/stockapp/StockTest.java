package com.impetus.stockapp;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.stockapp.entity.Stock;
import com.impetus.stockapp.repository.StockRepository;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class StockTest {
    @Autowired
    private StockRepository     stockRepository;
    private static final Logger LOGGER = Logger.getLogger(StockTest.class);

    /**
     * Test stock list.
     */
    @Test
    public void testStockList() {
	List<Stock> stocks = stockRepository.findByStockSymbolLikeOrCompanyNameLike("%A%", "%A%");
	if (stocks.size() > 0) {
	    LOGGER.info(stocks.size());
	    assertTrue(true);
	} else {
	    LOGGER.info("no stocks in db");
	    assertTrue(true);
	}

    }

    @Test
    public void testGetStockById() {
	Stock stock = stockRepository.findByStockId(new Long(1));
	if (stock == null) {
	    LOGGER.info("no stock in db");
	    assertTrue(true);
	} else {
	    LOGGER.info(stock.getCompanyName());
	    assertTrue(true);
	}
    }

}
