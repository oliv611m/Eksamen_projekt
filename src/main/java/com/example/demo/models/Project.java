package com.example.demo.models;

public class Project {
    private int project_id;
    private String name;
    private int numberOfemp;
    private int dayPrice;
    private int totalPrice;
    private int startDate;
    private int endDate;
    private int workingDays;
    private int workingHours;

    public Project(int project_id, String name, int numberOfemp, int dayPrice, int totalPrice, int startDate, int endDate, int workingDays, int workingHours) {
        this.project_id = project_id;
        this.name = name;
        this.numberOfemp = numberOfemp;
        this.dayPrice = dayPrice;
        this.totalPrice = totalPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.workingDays = workingDays;
        this.workingHours = workingHours;
    }


    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
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

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }
}
