package com.impetus.stockapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.stockapp.entity.Stock;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@Transactional(readOnly = true)
public interface StockRepository extends JpaRepository<Stock, Long> {
    /**
     * Method findByStockSymbolLikeOrCompanyNameLike.
     * @param stockSymbol String
     * @param companyName String
    
     * @return List<Stock> */
    List<Stock> findByStockSymbolLikeOrCompanyNameLike(String stockSymbol, String companyName);

    /**
     * Method findByStockId.
     * @param stockId Long
    
     * @return Stock */
    Stock findByStockId(Long stockId);

}
