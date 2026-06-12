package com.reward_points.dto;

import java.util.List;

/**
 * DTO containing customer reward summary.
 */
public class CustomerRewardResponseDTO {

    private Long customerId;
    private String customerName;
    private List<MonthlyRewardDTO> monthlyRewards;
    private Long totalRewards;

    /**
     * Returns customer id.
     *
     * @return customer id
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * Sets customer id.
     *
     * @param customerId customer id
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * Returns customer name.
     *
     * @return customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets customer name.
     *
     * @param customerName customer name
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Returns monthly reward details.
     *
     * @return monthly reward list
     */
    public List<MonthlyRewardDTO> getMonthlyRewards() {
        return monthlyRewards;
    }

    /**
     * Sets monthly reward details.
     *
     * @param monthlyRewards monthly reward list
     */
    public void setMonthlyRewards(List<MonthlyRewardDTO> monthlyRewards) {
        this.monthlyRewards = monthlyRewards;
    }

    /**
     * Returns total reward points.
     *
     * @return total reward points
     */
    public Long getTotalRewards() {
        return totalRewards;
    }

    /**
     * Sets total reward points.
     *
     * @param totalRewards total reward points
     */
    public void setTotalRewards(Long totalRewards) {
        this.totalRewards = totalRewards;
    }
}
