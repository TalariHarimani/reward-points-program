package com.reward_points;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Integration tests for RewardController.
 * <p>
 * Verifies REST API endpoints using
 * Spring Boot test context.
 */
@SpringBootTest
@AutoConfigureMockMvc
class RewardControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Valid customer should return rewards.
     */
    @Test
    @DisplayName("Should return rewards for valid customer")
    void shouldReturnRewardsForValidCustomer() throws Exception {

        mockMvc.perform(
                        get("/api/rewards/customer/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerId").value(1))
                .andExpect(jsonPath("$.customerName").value("Hari"))
                .andExpect(jsonPath("$.totalRewards").exists());
    }

    /**
     * Another valid customer.
     */
    @Test
    @DisplayName("Should return rewards for second customer")
    void shouldReturnRewardsForSecondCustomer() throws Exception {

        mockMvc.perform(
                        get("/api/rewards/customer/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerId").value(2))
                .andExpect(jsonPath("$.customerName").value("Nari"));
    }

    /**
     * Invalid customer should return 404.
     */
    @Test
    @DisplayName("Should return not found for invalid customer")
    void shouldReturnNotFoundForInvalidCustomer() throws Exception {

        mockMvc.perform(
                        get("/api/rewards/customer/999"))
                .andExpect(status().isNotFound());
    }

    /**
     * Get rewards for all customers.
     */
    @Test
    @DisplayName("Should return all customer rewards")
    void shouldReturnAllCustomerRewards() throws Exception {

        mockMvc.perform(
                        get("/api/rewards/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").exists());
    }

    /**
     * Verify response content type.
     */
    @Test
    @DisplayName("Should return JSON response")
    void shouldReturnJsonResponse() throws Exception {

        mockMvc.perform(
                        get("/api/rewards/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(
                        "application/json"));
    }
}