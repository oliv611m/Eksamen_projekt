package com.example.demo.models;

public class Project {
    private String startDay;
    private String endDay;
    private int dayPrice;
    private int totalPrice;
    private int workingDays;
    private int workingHours;
    private String subProject;
    private String projectName;
    private int numberOfemp;

    public Project() {

    }

    public Project(String startDay, String endDay, int dayPrice, int totalPrice, int workingDays, int workingHours,
                   String subProject, String projectName, int numberOfemp) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.dayPrice = dayPrice;
        this.totalPrice = totalPrice;
        this.workingDays = workingDays;
        this.workingHours = workingHours;
        this.subProject = subProject;
        this.projectName = projectName;
        this.numberOfemp = numberOfemp;
    }


    public int getNumberOfemp() { return numberOfemp; }
    public void setNumberOfemp(int numberOfemp) { this.numberOfemp = numberOfemp; }

    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }

    public String getSubProject() { return subProject; }
    public void setSubProject(String subProject) { this.subProject = subProject; }

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
}
