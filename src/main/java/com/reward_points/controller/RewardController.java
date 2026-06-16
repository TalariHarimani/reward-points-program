package com.reward_points.controller;

import com.reward_points.dto.CustomerRewardResponseDTO;

import com.reward_points.service.RewardService;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST Controller responsible for handling reward-related requests.
 *
 * <p>This controller exposes APIs to:
 * <ul>
 *     <li>Retrieve reward points for a specific customer</li>
 *     <li>Retrieve reward points for all customers</li>
 *     <li>Calculate reward points for a specific transaction</li>
 * </ul>
 */
@RestController
@RequestMapping("/api/rewards")
@Validated
public class RewardController {

    private final RewardService rewardService;

    /**
     * Constructor-based dependency injection for RewardService.
     *
     * @param rewardService service responsible for reward point calculations
     *                      and customer reward retrieval operations
     */
    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    /**
     * Retrieves reward information for a specific customer.
     *
     * <p>This API calculates and returns:
     * <ul>
     *     <li>Monthly reward points</li>
     *     <li>Total reward points</li>
     * </ul>
     * for the given customer.
     *
     * @param customerId unique identifier of the customer
     * @return CustomerRewardResponseDTO containing monthly and total reward points
     */
    @GetMapping("customer/{customerId}")
    public CustomerRewardResponseDTO getCustomerRewards(
            @PathVariable
            @Positive(message = "Customer Id must be greater than zero")
            Long customerId) {

        return rewardService.getCustomerRewards(customerId);
    }

    /**
     * Retrieves reward details for all customers.
     *
     * <p>This API returns reward summaries including monthly and total
     * reward points for every customer available in the system.
     *
     * @return list of customer reward response objects
     */
    @GetMapping("/all")
    public List<CustomerRewardResponseDTO> getAllRewards() {

        return rewardService.getAllCustomerRewards();
    }

    /**
     * Calculates reward points for a specific transaction.
     *
     * <p>Reward calculation rules:
     * <ul>
     *     <li>2 points for every dollar spent above $100</li>
     *     <li>1 point for every dollar spent between $50 and $100</li>
     * </ul>
     *
     * @param transactionId unique identifier of the transaction
     * @return calculated reward points for the transaction
     */
    @GetMapping("/transaction/{transactionId}")
    public Long getTransactionReward(
            @PathVariable
            @Positive(message = "Transaction Id must be greater than zero")
            Long transactionId) {

        return rewardService.calculateRewardPoints(
                transactionId);
    }
}
