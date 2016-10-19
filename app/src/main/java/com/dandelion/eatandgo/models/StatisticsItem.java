package com.dandelion.eatandgo.models;

public class StatisticsItem {

    private String foodWeight;
    private String waterWeight;
    private String date;

    public StatisticsItem(String foodWeight, String waterWeight, String date) {
        this.foodWeight = foodWeight;
        this.waterWeight = waterWeight;
        this.date = date;
    }

    public String getFoodWeight() {
        return foodWeight;
    }

    public void setFoodWeight(String foodWeight) {
        this.foodWeight = foodWeight;
    }

    public String getWaterWeight() {
        return waterWeight;
    }

    public void setWaterWeight(String waterWeight) {
        this.waterWeight = waterWeight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
