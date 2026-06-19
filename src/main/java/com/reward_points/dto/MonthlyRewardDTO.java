package com.reward_points.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

/**
 * DTO representing reward points earned by a customer
 * for a particular month.
 */
@Data
public class MonthlyRewardDTO {

    /**
     * Month and year in YYYY-MM format.
     */
    @NotBlank(message = "Month and year cannot be blank")
    private String monthYear;

    /**
     * Reward points earned for the month.
     */
    @NotNull(message = "Reward points cannot be null")
    @PositiveOrZero(message = "Reward points cannot be negative")
    private Long rewardPoints;

    /**
     * Default constructor.
     */
    public MonthlyRewardDTO() {
    }

    /**
     * Parameterized constructor.
     *
     * @param monthYear    month and year
     * @param rewardPoints reward points earned
     */
    public MonthlyRewardDTO(String monthYear, Long rewardPoints) {
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
