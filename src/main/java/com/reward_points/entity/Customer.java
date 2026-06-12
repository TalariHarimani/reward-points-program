package com.reward_points.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity representing customer information stored in the database.
 *
 * <p>This entity maps to the {@code customers} table and contains
 * customer-related details used in reward point calculations.
 */
@Entity
@Table(name = "customers")
public class Customer {
    /**
     * Unique identifier of the customer.
     */
    @Id
    @Column(name = "customer_id")
    private Long customerId;
    /**
     * Name of the customer.
     */
    @Column(name = "customer_name")
    private String customerName;

    /**
     * Retrieves the customer ID.
     *
     * @return the unique customer identifier
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer ID.
     *
     * @param customerId unique identifier of the customer
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * Retrieves the customer name.
     *
     * @return customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the customer name.
     *
     * @param customerName name of the customer
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
