package com.impetus.stockapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.stockapp.entity.Stock;
import com.impetus.stockapp.repository.StockRepository;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;

    /**
     * Method searchForStock.
     * @param stockSymbol String
    
    
     * @return List<Stock> * @see com.impetus.stockapp.service.StockService#searchForStock(String) */
    public List<Stock> searchForStock(final String stockSymbol) {
	String searchpattern = "%" + stockSymbol + "%";
	return stockRepository.findByStockSymbolLikeOrCompanyNameLike(searchpattern, searchpattern);
    }

    /**
     * Method getLiveStock.
     * @param stockId Long
    
    
     * @return Stock * @see com.impetus.stockapp.service.StockService#getLiveStock(Long) */
    @Override
    public Stock getLiveStock(final Long stockId) {
	// TODO Auto-generated method stub
	return stockRepository.findByStockId(stockId);
    }
}
