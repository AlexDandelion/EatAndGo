package com.dandelion.eatandgo.model;

public class ScheduleItem {

    private String foodWeight;
    private String feedingTime;

    public ScheduleItem(String foodWeight, String feedingTime) {

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
