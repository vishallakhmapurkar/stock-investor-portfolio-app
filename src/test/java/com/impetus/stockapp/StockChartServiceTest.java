package com.impetus.stockapp;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.impetus.stockapp.entity.StockPerDayDetail;
import com.impetus.stockapp.entity.StockYearDetail;
import com.impetus.stockapp.exception.StockApplicationException;
import com.impetus.stockapp.service.StockChartService;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class StockChartServiceTest {
    @Autowired
    private StockChartService stockChartService;
    
    /**
     * Method testYearlyStockDetails.
     * 
     * @throws StockApplicationException
     */
    @Ignore
    public void testYearlyStockDetails() throws StockApplicationException {
	List<StockYearDetail> stocks = stockChartService.getYearlyStockDetails(1L);
	assertNotNull(stocks);
    }
    
    @Test
    public void testDayStockDetails() throws StockApplicationException, ParseException {
	java.sql.Date javaSqlDate = java.sql.Date.valueOf("2012-11-07");
	List<StockPerDayDetail> stocks = stockChartService.getDayStockDetails(1L, javaSqlDate);
	assertNotNull(stocks);
    }
}
