package com.impetus.stockapp.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.stockapp.entity.InvestorStocksDetails;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
public interface InvesterStocksRepository extends JpaRepository<InvestorStocksDetails, Long> {

    // @Modifying
    // @Transactional
    // @Query("DELETE FROM InvestorStocksDetails i WHERE i.stockId=?1")
    // void deleteStockId(Long stockId);

    /**
     * Method updateInvesterSTock.
     * @param quantity int
     * @param purchaseDate Date
     * @param purchaseprice double
     * @param investerstockID Long
    
     * @return int */
    @Modifying
    @Transactional
    @Query("UPDATE InvestorStocksDetails i SET i.quantity = :quantity,i.purchasedate = :purchaseDate,i.purchasePrice = :purchaseprice WHERE i.investerStockDetailsId=:investerstockID")
    public int updateInvesterSTock(@Param("quantity") int quantity, @Param("purchaseDate") Date purchaseDate,
	    @Param("purchaseprice") double purchaseprice, @Param("investerstockID") Long investerstockID);

    /**
     * Method resetEmailAlert.
     * @param variant Long
     * @param emailAlert int
     * @param investerstockID Long
    
     * @return int */
    @Modifying
    @Transactional
    @Query("UPDATE InvestorStocksDetails i SET i.varient = ?1,i.isEmailAlertActivate = ?2 WHERE i.investerStockDetailsId =?3")
    public int resetEmailAlert(Long variant, int emailAlert, Long investerstockID);

}
