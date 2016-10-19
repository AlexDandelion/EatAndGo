package com.dandelion.eatandgo.models;

public class ScheduleItem {

    private String foodWeight;
    private String feedingHours;
    private String feedingMinutes;

    public ScheduleItem(String foodWeight, String feedingHours, String feedingMinutes) {
        this.foodWeight = foodWeight;
        this.feedingHours = feedingHours;
        this.feedingMinutes = feedingMinutes;
    }

    public String getFoodWeight() {
        return foodWeight;
    }

    public void setFoodWeight(String foodWeight) {
        this.foodWeight = foodWeight;
    }

    public String getFeedingHours() {
        return feedingHours;
    }

    public void setFeedingHours(String feedingHours) {
        this.feedingHours = feedingHours;
    }

    public String getFeedingMinutes() {
        return feedingMinutes;
    }

    public void setFeedingMinutes(String feedingMinutes) {
        this.feedingMinutes = feedingMinutes;
    }
}
