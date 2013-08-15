package com.impetus.stockapp;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.test.context.ContextConfiguration;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all of the tests within its package as well as
 * within any subpackages of its package.
 * 
 * @generatedBy CodePro at 10/3/12 6:27 PM
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@RunWith(Suite.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Suite.SuiteClasses({

ConfigTest.class, HttpClientTest.class, InvestorStocksServiceTest.class, InvestorServiceTest.class,
        InvestorStockBeanTest.class, InvestorStocksTest.class, InvestorTest.class, LoginServiceTest.class,
        StockChartServiceTest.class, StockServiceTest.class, StockTest.class, StockYearDetailsTest.class

})
public class TestAll {
    
    /**
     * Launch the test.
     * 
     * @param args
     *            the command line arguments
     * 
     * @generatedBy CodePro at 10/3/12 6:27 PM
     */
    public static void main(String[] args) {
	JUnitCore.runClasses(new Class[] { TestAll.class });
    }
}
