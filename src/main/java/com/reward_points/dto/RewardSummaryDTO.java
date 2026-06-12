package com.reward_points.dto;

/**
 * DTO representing reward summary details for a
 * specific month and year.
 * <p>
 * This DTO contains the month-wise reward points
 * earned by a customer.
 */
public class RewardSummaryDTO {

    /**
     * Month and year in YYYY-MM format.
     */
    private String monthYear;

    /**
     * Reward points earned for the month.
     */
    private Long rewardPoints;

    /**
     * Default constructor.
     */
    public RewardSummaryDTO() {
    }

    /**
     * Parameterized constructor.
     *
     * @param monthYear    month and year
     * @param rewardPoints reward points earned
     */
    public RewardSummaryDTO(String monthYear, Long rewardPoints) {
        this.monthYear = monthYear;
        this.rewardPoints = rewardPoints;
    }

    /**
     * Returns month and year.
     *
     * @return month and year
     */
    public String getMonthYear() {
        return monthYear;
    }

    /**
     * Sets month and year.
     *
     * @param monthYear month and year
     */
    public void setMonthYear(String monthYear) {
        this.monthYear = monthYear;
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
     * @param rewardPoints reward points earned
     */
    public void setRewardPoints(Long rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    @Override
    public String toString() {
        return "RewardSummaryDTO{" +
                "monthYear='" + monthYear + '\'' +
                ", rewardPoints=" + rewardPoints +
                '}';
    }
}