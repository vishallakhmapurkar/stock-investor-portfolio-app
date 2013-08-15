package com.impetus.stockapp.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.stockapp.entity.StockPerDayDetail;
import com.impetus.stockapp.entity.StockYearDetail;
import com.impetus.stockapp.exception.StockApplicationException;
import com.impetus.stockapp.repository.StockDailyRepository;
import com.impetus.stockapp.repository.StockYearDetailsRepository;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@Service
public class StockChartServiceImpl implements StockChartService {
    @Autowired
    private StockYearDetailsRepository stockYearDetailsRepository;
    @Autowired
    private StockDailyRepository       stockDailyRepository;
    
    /**
     * Method getYearlyStockDetails.
     * 
     * @param stockId
     *            Long
     * 
     * 
     * @return List<StockYearDetail> * @see com.impetus.stockapp.service.StockChartService#getYearlyStockDetails(Long)
     */
    @Override
    public List<StockYearDetail> getYearlyStockDetails(final Long stockId) {
	return stockYearDetailsRepository.findByStockIdOrderByStockEntryDateAsc(stockId);
    }
    
    @Override
    public List<StockPerDayDetail> getDayStockDetails(Long stockId, Date entry_date) throws StockApplicationException {
	return stockDailyRepository.findByStockIdAndEntryDate(stockId, entry_date);
    }
    
}
