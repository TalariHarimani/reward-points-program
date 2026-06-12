package com.reward_points.repository;

import com.reward_points.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for performing database operations on
 * the Transaction entity.
 *
 * <p>This repository extends JpaRepository to provide standard
 * CRUD operations and custom query methods for transaction data.
 * <p>
 * It is used to retrieve customer transactions required for
 * reward point calculations and monthly reward summaries.
 */
@Repository
public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    /**
     * Retrieves all transactions belonging to a specific customer.
     *
     * <p>Spring Data JPA automatically generates the query based
     * on the method name.
     * <p>
     * Example generated query:
     * <pre>
     * SELECT t
     * FROM Transaction t
     * WHERE t.customerId = :customerId
     * </pre>
     *
     * @param customerId unique identifier of the customer
     * @return list of transactions associated with the customer
     */
    List<Transaction> findByCustomerId(Long customerId);
}
