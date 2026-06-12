package com.reward_points.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entity representing customer transaction details.
 *
 * <p>This entity maps to the {@code transactions} table and stores
 * transaction information used for reward point calculations.
 * <p>
 * Each transaction belongs to a customer and contains the purchase
 * amount along with the transaction date.
 */
@Entity
@Table(name = "transactions")
public class Transaction {
    /**
     * Unique identifier of the transaction.
     */
    @Id
    private Long transactionId;

    /**
     * Identifier of the customer who performed the transaction.
     */
    private Long customerId;

    /**
     * Transaction amount used for reward point calculation.
     */
    private BigDecimal amount;

    /**
     * Date on which the transaction occurred.
     */
    private LocalDate transactionDate;

    /**
     * Retrieves the transaction ID.
     *
     * @return unique transaction identifier
     */
    public Long getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the transaction ID.
     *
     * @param transactionId unique transaction identifier
     */
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Retrieves the customer ID.
     *
     * @return customer identifier
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer ID.
     *
     * @param customerId customer identifier
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * Retrieves the transaction amount.
     *
     * @return transaction amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the transaction amount.
     *
     * @param amount transaction amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Retrieves the transaction date.
     *
     * @return date of transaction
     */
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    /**
     * Sets the transaction date.
     *
     * @param transactionDate date of transaction
     */
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
}
