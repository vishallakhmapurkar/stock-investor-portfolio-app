package com.impetus.stockapp.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.impetus.stockapp.entity.StockPerDayDetail;

public interface StockDailyRepository extends JpaRepository<StockPerDayDetail, Long> {
    List<StockPerDayDetail> findByStockIdAndEntryDate(Long stockId, Date entry_date);
}
