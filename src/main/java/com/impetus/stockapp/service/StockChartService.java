package com.impetus.stockapp.service;

import java.sql.Date;
import java.util.List;

import com.impetus.stockapp.entity.StockPerDayDetail;
import com.impetus.stockapp.entity.StockYearDetail;
import com.impetus.stockapp.exception.StockApplicationException;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
public interface StockChartService {
    /**
     * Method getYearlyStockDetails.
     * 
     * @param stockId
     *            Long
     * 
     * 
     * @return List<StockYearDetail> * @throws StockApplicationException
     */
    List<StockYearDetail> getYearlyStockDetails(Long stockId) throws StockApplicationException;
    
    List<StockPerDayDetail> getDayStockDetails(Long stockId, Date dt) throws StockApplicationException;
}
