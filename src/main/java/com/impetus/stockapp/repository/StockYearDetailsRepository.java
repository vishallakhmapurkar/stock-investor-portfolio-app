package com.impetus.stockapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.impetus.stockapp.entity.StockYearDetail;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
public interface StockYearDetailsRepository extends JpaRepository<StockYearDetail, Long> {
    /**
     * Method findByStockIdOrderByStockEntryDateAsc.
     * @param stockId Long
    
     * @return List<StockYearDetail> */
    List<StockYearDetail> findByStockIdOrderByStockEntryDateAsc(Long stockId);
}
