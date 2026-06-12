package com.reward_points.dto;


/**
 * DTO representing reward points earned by a customer
 * for a particular month.
 */
public class MonthlyRewardDTO {

    private String month;
    private Long rewardPoints;

    /**
     * Default Constructor.
     */
    public MonthlyRewardDTO() {
    }

    /**
     * Parameterized Constructor.
     *
     * @param month        month and year
     * @param rewardPoints reward points earned
     */
    public MonthlyRewardDTO(String month, Long rewardPoints) {
        this.month = month;
        this.rewardPoints = rewardPoints;
    }

    /**
     * Returns month.
     *
     * @return month
     */
    public String getMonth() {
        return month;
    }

    /**
     * Sets month.
     *
     * @param month month
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * Returns reward points.
     *
     * @return reward points
     */
    public Long getRewardPoints() {
        return rewardPoints;
    }

    /**
     * Sets reward points.
     *
     * @param rewardPoints reward points
     */
    public void setRewardPoints(Long rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
}
