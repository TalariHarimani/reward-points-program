package com.reward_points.service;

import com.reward_points.dto.CustomerRewardResponseDTO;

import java.util.List;

/**
 * Service interface for reward point calculations and
 * customer reward summary operations.
 *
 * <p>This service defines the business operations required
 * to calculate reward points for transactions and retrieve
 * reward summaries for customers.
 * <p>
 * The implementation of this interface contains the business
 * logic for calculating rewards based on transaction amounts.
 */
public interface RewardService {

    /**
     * Retrieves reward details for a specific customer.
     *
     * <p>The response includes:
     * <ul>
     *     <li>Customer information</li>
     *     <li>Monthly reward points</li>
     *     <li>Total reward points</li>
     * </ul>
     *
     * @param customerId unique identifier of the customer
     * @return customer reward summary
     */
    CustomerRewardResponseDTO getCustomerRewards(Long customerId);

    /**
     * Retrieves reward summaries for all customers.
     *
     * <p>This method calculates and returns reward points
     * for every customer available in the system.
     *
     * @return list of customer reward summaries
     */
    List<CustomerRewardResponseDTO> getAllCustomerRewards();

    /**
     * Calculates reward points for a specific transaction.
     *
     * <p>Reward calculation rules:
     * <ul>
     *     <li>2 points for every dollar spent above $100</li>
     *     <li>1 point for every dollar spent between $50 and $100</li>
     * </ul>
     * <p>
     * Example:
     * <pre>
     * Transaction Amount = $120
     * Points = (20 × 2) + (50 × 1)
     * Points = 90
     * </pre>
     *
     * @param transactionId unique identifier of the transaction
     * @return calculated reward points
     */
    Long calculateRewardPoints(Long transactionId);
}
