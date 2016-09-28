package com.dandelion.eatandgo.dto;

public class ScheduleDTO {

    private String foodWeight;
    private String feedingTime;

    public ScheduleDTO(String foodWeight, String feedingTime) {

        this.foodWeight = foodWeight;
        this.feedingTime = feedingTime;
    }

    public String getFoodWeight() {
        return foodWeight;
    }

    public void setFoodWeight(String foodWeight) {
        this.foodWeight = foodWeight;
    }

    public String getFeedingTime() {
        return feedingTime;
    }

    public void setFeedingTime(String feedingTime) {
        this.feedingTime = feedingTime;
    }
}
