package com.dandelion.eatandgo.model;

public class StatisticsItem {

    private String type;
    private String weight;
    private String time;

    public StatisticsItem(String type, String weight, String time) {
        this.type = type;
        this.weight = weight;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
