package com.impetus.stockapp.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.impetus.stockapp.entity.Investor;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
public interface InvestorRepository extends JpaRepository<Investor, Long> {
    /**
     * Method exist.
     * @param username String
    
     * @return Long */
    @Query("SELECT COUNT(email) FROM Investor WHERE username=?1")
    Long exist(String username);

    /**
     * Method findByUsernameAndPassword.
     * @param username String
     * @param password String
    
    
     * @return Investor * @throws DataAccessException */
    Investor findByUsernameAndPassword(String username, String password) throws DataAccessException;

    /**
     * Method getPassword.
     * @param email String
    
    
     * @return Investor * @throws DataAccessException */
    @Query("SELECT i FROM Investor i WHERE i.email=?1")
    Investor getPassword(String email) throws DataAccessException;

    /**
     * Method emailIdExist.
     * @param email String
    
    
     * @return Long * @throws DataAccessException */
    @Query("SELECT COUNT(email) FROM Investor WHERE email=?1")
    Long emailIdExist(String email) throws DataAccessException;

}
