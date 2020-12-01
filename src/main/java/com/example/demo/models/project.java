package com.example.demo.models;

public class project {
    private String name;
    private int numberOfemp;
    private int dayPrice;
    private int totalPrice;
    private int startDate;
    private int endDate;

    public project(String name, int numberOfemp, int dayPrice, int totalPrice, int startDate, int endDate) {
        this.name = name;
        this.numberOfemp = numberOfemp;
        this.dayPrice = dayPrice;
        this.totalPrice = totalPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfemp() {
        return numberOfemp;
    }

    public void setNumberOfemp(int numberOfemp) {
        this.numberOfemp = numberOfemp;
    }

    public int getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(int dayPrice) {
        this.dayPrice = dayPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

}
