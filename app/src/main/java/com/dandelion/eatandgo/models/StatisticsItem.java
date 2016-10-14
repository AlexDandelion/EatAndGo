package com.dandelion.eatandgo.models;

public class StatisticsItem {

    private String type;
    private String weight;
    private String date;

    public StatisticsItem(String type, String weight, String date) {
        this.type = type;
        this.weight = weight;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
