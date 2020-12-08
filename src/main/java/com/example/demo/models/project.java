package com.example.demo.models;

public class project {
    private String name;
    private int numberOfemp;
    private int dayPrice;
    private int totalPrice;
    private int startDate;
    private int endDate;
    private int workingDays;
    private int workingHours;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getNumberOfemp() { return numberOfemp; }
    public void setNumberOfemp(int numberOfemp) { this.numberOfemp = numberOfemp; }

    public int getDayPrice() { return dayPrice; }
    public void setDayPrice(int dayPrice) { this.dayPrice = dayPrice; }

    public int getTotalPrice() { return totalPrice; }
    public void setTotalPrice(int totalPrice) { this.totalPrice = totalPrice; }

    public int getStartDate() { return startDate; }
    public void setStartDate(int startDate) { this.startDate = startDate; }

    public int getEndDate() { return endDate; }
    public void setEndDate(int endDate) { this.endDate = endDate; }

    public int getWorkingDays() { return workingDays; }
    public void setWorkingDays(int workingDays) { this.workingDays = workingDays; }

    public int getWorkingHours(){ return workingHours; }
    public void setWorkingHours(int workingHours){ this.workingHours = workingHours; }

}
