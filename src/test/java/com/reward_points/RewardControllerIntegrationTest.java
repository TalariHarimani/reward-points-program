package com.reward_points;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests for RewardController.
 * <p>
 * Verifies REST API endpoints using
 * the Spring Boot application context.
 */
@SpringBootTest
@AutoConfigureMockMvc
class RewardControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Verifies rewards are returned
     * for a valid customer.
     */
    @Test
    @DisplayName("Should return rewards for valid customer")
    void shouldReturnRewardsForValidCustomer()
            throws Exception {

        mockMvc.perform(
                        get("/api/rewards/customer/1")
                                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(
                        jsonPath("$.customerId")
                                .value(1))
                .andExpect(
                        jsonPath("$.customerName")
                                .value("Hari"))
                .andExpect(
                        jsonPath("$.totalRewards")
                                .exists());
    }

    /**
     * Verifies all customer rewards
     * are returned successfully.
     */
    @Test
    @DisplayName("Should return all customer rewards")
    void shouldReturnAllCustomerRewards()
            throws Exception {

        mockMvc.perform(
                        get("/api/rewards/all")
                                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }


    /**
     * Verifies invalid customer id
     * returns NOT FOUND.
     */
    @Test
    @DisplayName("Should return not found for invalid customer")
    void shouldReturnNotFoundForInvalidCustomer()
            throws Exception {

        mockMvc.perform(
                        get("/api/rewards/customer/999")
                                .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


    /**
     * Verifies negative customer id
     * returns BAD REQUEST.
     */
    @Test
    @DisplayName("Should return bad request for negative customer id")
    void shouldReturnBadRequestForNegativeCustomerId()
            throws Exception {

        mockMvc.perform(
                        get("/api/rewards/customer/-1")
                                .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }


}