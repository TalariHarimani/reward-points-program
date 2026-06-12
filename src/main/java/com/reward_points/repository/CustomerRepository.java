package com.reward_points.repository;

import com.reward_points.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for performing database operations on
 * the Customer entity.
 *
 * <p>This repository extends JpaRepository, which provides
 * built-in CRUD operations such as:
 * <ul>
 *     <li>save()</li>
 *     <li>findById()</li>
 *     <li>findAll()</li>
 *     <li>deleteById()</li>
 * </ul>
 * <p>
 * No custom queries are required because the standard JPA
 * methods are sufficient for retrieving customer information.
 */
@Repository
public interface CustomerRepository
        extends JpaRepository<Customer, Long> {
}
