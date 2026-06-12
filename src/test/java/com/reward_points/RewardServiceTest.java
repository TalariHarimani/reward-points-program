package com.reward_points;

import com.reward_points.entity.Transaction;
import com.reward_points.exception.ResourceNotFoundException;
import com.reward_points.repository.CustomerRepository;
import com.reward_points.repository.TransactionRepository;
import com.reward_points.service.RewardServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * Unit tests for RewardServiceImpl.
 * <p>
 * Verifies reward point calculations
 * for various transaction amounts.
 */
class RewardServiceImplTest {

    private RewardServiceImpl rewardService;

    private TransactionRepository transactionRepository;

    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {

        transactionRepository =
                Mockito.mock(TransactionRepository.class);

        customerRepository =
                Mockito.mock(CustomerRepository.class);

        rewardService =
                new RewardServiceImpl(
                        transactionRepository,
                        customerRepository);
    }

    /**
     * Amount less than $50 should earn 0 points.
     */
    @Test
    @DisplayName("Should return zero points for amount below 50")
    void shouldReturnZeroPointsForAmountBelow50() {

        Transaction transaction = new Transaction();
        transaction.setTransactionId(1L);
        transaction.setAmount(BigDecimal.valueOf(40));

        when(transactionRepository.findById(1L))
                .thenReturn(Optional.of(transaction));

        Long points =
                rewardService.calculateRewardPoints(1L);

        assertEquals(0L, points);
    }

    /**
     * Amount exactly $50 should earn 0 points.
     */
    @Test
    @DisplayName("Should return zero points for amount equal to 50")
    void shouldReturnZeroPointsForAmountEqual50() {

        Transaction transaction = new Transaction();
        transaction.setTransactionId(2L);
        transaction.setAmount(BigDecimal.valueOf(50));

        when(transactionRepository.findById(2L))
                .thenReturn(Optional.of(transaction));

        Long points =
                rewardService.calculateRewardPoints(2L);

        assertEquals(0L, points);
    }

    /**
     * Amount between $50 and $100.
     */
    @Test
    @DisplayName("Should calculate points between 50 and 100")
    void shouldCalculatePointsBetween50And100() {

        Transaction transaction = new Transaction();
        transaction.setTransactionId(3L);
        transaction.setAmount(BigDecimal.valueOf(75));

        when(transactionRepository.findById(3L))
                .thenReturn(Optional.of(transaction));

        Long points =
                rewardService.calculateRewardPoints(3L);

        assertEquals(25L, points);
    }

    /**
     * Amount exactly $100.
     */
    @Test
    @DisplayName("Should calculate points for amount equal to 100")
    void shouldCalculatePointsFor100() {

        Transaction transaction = new Transaction();
        transaction.setTransactionId(4L);
        transaction.setAmount(BigDecimal.valueOf(100));

        when(transactionRepository.findById(4L))
                .thenReturn(Optional.of(transaction));

        Long points =
                rewardService.calculateRewardPoints(4L);

        assertEquals(50L, points);
    }

    /**
     * Assignment example.
     * <p>
     * 120 => 90 points
     */
    @Test
    @DisplayName("Should calculate reward for 120")
    void shouldCalculateRewardFor120() {

        Transaction transaction = new Transaction();
        transaction.setTransactionId(5L);
        transaction.setAmount(BigDecimal.valueOf(120));

        when(transactionRepository.findById(5L))
                .thenReturn(Optional.of(transaction));

        Long points =
                rewardService.calculateRewardPoints(5L);

        assertEquals(90L, points);
    }

    /**
     * Large purchase validation.
     */
    @Test
    @DisplayName("Should calculate reward for 200")
    void shouldCalculateRewardFor200() {

        Transaction transaction = new Transaction();
        transaction.setTransactionId(6L);
        transaction.setAmount(BigDecimal.valueOf(200));

        when(transactionRepository.findById(6L))
                .thenReturn(Optional.of(transaction));

        Long points =
                rewardService.calculateRewardPoints(6L);

        assertEquals(250L, points);
    }

    /**
     * Boundary condition.
     */
    @Test
    @DisplayName("Should calculate reward for 101")
    void shouldCalculateRewardFor101() {

        Transaction transaction = new Transaction();
        transaction.setTransactionId(7L);
        transaction.setAmount(BigDecimal.valueOf(101));

        when(transactionRepository.findById(7L))
                .thenReturn(Optional.of(transaction));

        Long points =
                rewardService.calculateRewardPoints(7L);

        assertEquals(52L, points);
    }

    /**
     * Negative amount scenario.
     */
    @Test
    @DisplayName("Should return zero for negative amount")
    void shouldReturnZeroForNegativeAmount() {

        Transaction transaction = new Transaction();
        transaction.setTransactionId(8L);
        transaction.setAmount(BigDecimal.valueOf(-100));

        when(transactionRepository.findById(8L))
                .thenReturn(Optional.of(transaction));

        Long points =
                rewardService.calculateRewardPoints(8L);

        assertEquals(0L, points);
    }

    /**
     * Invalid transaction id.
     */
    @Test
    @DisplayName("Should throw exception for invalid transaction")
    void shouldThrowExceptionForInvalidTransaction() {

        when(transactionRepository.findById(999L))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> rewardService.calculateRewardPoints(999L)
        );
    }
}