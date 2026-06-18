package com.reward_points.service;

import com.reward_points.dto.CustomerRewardResponseDTO;
import com.reward_points.dto.MonthlyRewardDTO;
import com.reward_points.entity.Customer;
import com.reward_points.entity.Transaction;
import com.reward_points.exception.ResourceNotFoundException;
import com.reward_points.repository.CustomerRepository;
import com.reward_points.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service implementation responsible for
 * calculating customer reward points.
 */
@Service
public class RewardServiceImpl implements RewardService {

    private final TransactionRepository transactionRepository;
    private final CustomerRepository customerRepository;

    /**
     * Constructor injection.
     *
     * @param transactionRepository transaction repository
     * @param customerRepository    customer repository
     */
    public RewardServiceImpl(TransactionRepository transactionRepository,
                             CustomerRepository customerRepository) {
        this.transactionRepository = transactionRepository;
        this.customerRepository = customerRepository;
    }

    /**
     * Returns reward summary for a customer.
     *
     * @param customerId customer id
     * @return reward response
     */
    @Override
    public CustomerRewardResponseDTO getCustomerRewards(Long customerId) {


        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Customer not found : " + customerId));

        List<Transaction> transactions =
                transactionRepository.findByCustomerId(customerId);

        CustomerRewardResponseDTO response =
                new CustomerRewardResponseDTO();

        response.setCustomerId(customer.getCustomerId());
        response.setCustomerName(customer.getCustomerName());

        if (transactions.isEmpty()) {

            response.setMonthlyRewards(Collections.emptyList());
            response.setTotalRewards(0L);
            response.setMessage("Customer has no transactions available");

            return response;
        }

        Map<YearMonth, Long> monthlyRewards =
                transactions.stream()
                        .collect(Collectors.groupingBy(
                                transaction ->
                                        YearMonth.from(
                                                transaction.getTransactionDate()),
                                Collectors.summingLong(
                                        transaction ->
                                                calculatePoints(
                                                        transaction.getAmount())
                                )));

        List<MonthlyRewardDTO> rewardSummary =
                monthlyRewards.entrySet()
                        .stream()
                        .map(entry ->
                                new MonthlyRewardDTO(
                                        entry.getKey().toString(),
                                        entry.getValue()))
                        .toList();

        long totalRewards =
                rewardSummary.stream()
                        .mapToLong(
                                MonthlyRewardDTO::getRewardPoints)
                        .sum();

        response.setMonthlyRewards(rewardSummary);
        response.setTotalRewards(totalRewards);
        response.setMessage("Rewards calculated successfully");

        return response;
    }


    /**
     * Returns rewards for all customers.
     *
     * @return customer rewards list
     */
    @Override
    public List<CustomerRewardResponseDTO> getAllCustomerRewards() {

        return customerRepository.findAll()
                .stream()
                .map(customer ->
                        getCustomerRewards(
                                customer.getCustomerId()))
                .toList();
    }

    /**
     * Calculates reward points for a transaction.
     *
     * @param transactionId transaction id
     * @return reward points
     */
    @Override
    public Long calculateRewardPoints(Long transactionId) {

        Transaction transaction =
                transactionRepository.findById(transactionId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Transaction not found : "
                                                + transactionId));

        return calculatePoints(
                transaction.getAmount());
    }

    /**
     * Reward calculation logic.
     * <p>
     * Rules:
     * - 0 points for first $50
     * - 1 point for every dollar between $50 and $100
     * - 2 points for every dollar above $100
     *
     * @param amount transaction amount
     * @return reward points
     */
    private long calculatePoints(BigDecimal amount) {

        long purchaseAmount = amount.longValue();

        if (purchaseAmount <= 50) {
            return 0;
        }

        if (purchaseAmount <= 100) {
            return purchaseAmount - 50;
        }

        return ((purchaseAmount - 100) * 2L) + 50;
    }
}