package com.example.demo.models;

public class Project {
    private int projectID;
    private String startDay;
    private String endDay;
    private int dayPrice;
    private int totalPrice;
    private int workingDays;
    private int workingHours;
    private String projectName;
    private int numberOfemp;
    private String description;


    public Project() {}

    public int getProjectID() { return projectID; }
    public void setProjectID(int projectID) { this.projectID = projectID; }

    public int getNumberOfemp() { return numberOfemp; }
    public void setNumberOfemp(int numberOfemp) { this.numberOfemp = numberOfemp; }

    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }


    public int getWorkingHours() { return workingHours; }
    public void setWorkingHours(int workingHours) { this.workingHours = workingHours; }

    public int getTotalPrice() { return totalPrice; }
    public void setTotalPrice(int totalPrice) { this.totalPrice = totalPrice; }

    public int getWorkingDays() { return workingDays; }
    public void setWorkingDays(int workingDays) { this.workingDays = workingDays;}

    public int getDayPrice() {
        return dayPrice;
    }
    public void setDayPrice(int dayPrice) {
        this.dayPrice = dayPrice;
    }

    public String getStartDay() {
        return startDay;
    }
    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }
    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

}
