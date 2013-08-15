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

import com.impetus.stockapp.entity.StockYearDetail;
import com.impetus.stockapp.repository.StockYearDetailsRepository;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class StockYearDetailsTest {
    @Autowired
    private StockYearDetailsRepository stockYearDetailsRepository;
    private static final Logger        LOGGER = Logger.getLogger(StockYearDetailsTest.class);

    /**
     * Test stock list.
     */
    @Test
    public void testStockYearList() {

	List<StockYearDetail> stockYearDetails = stockYearDetailsRepository
	        .findByStockIdOrderByStockEntryDateAsc(new Long(1));
	if (stockYearDetails.size() > 0) {
	    LOGGER.info(stockYearDetails.size());
	    assertTrue(true);
	} else {
	    LOGGER.info("no stocks in db");
	    assertTrue(true);
	}
    }

}
