package com.example.demo.models;

public class SubProject {
    private String subProjectName;
    private String procentDays;
    private String procentHours;
    private String procentPrices;
    private String procentEmp;
    private int estimation;

    public SubProject(){}

    public SubProject(String subProjectName, String procentDays, String procentHours, String procentPrices, String procentEmp, int estimation) {
        this.subProjectName = subProjectName;
        this.procentDays = procentDays;
        this.procentHours = procentHours;
        this.procentPrices = procentPrices;
        this.procentEmp = procentEmp;
        this.estimation = estimation;
    }

    public String getSubProjectName() { return subProjectName; }
    public void setSubProjectName(String subProjectName) { this.subProjectName = subProjectName; }

    public String getProcentDays() { return procentDays; }
    public void setProcentDays(String procentDays) { this.procentDays = procentDays; }

    public String getProcentHours() { return procentHours; }
    public void setProcentHours(String procentHours) { this.procentHours = procentHours; }

    public String getProcentPrices() { return procentPrices; }
    public void setProcentPrices(String procentPrices) { this.procentPrices = procentPrices; }

    public String getProcentEmp() { return procentEmp; }
    public void setProcentEmp(String procentEmp) { this.procentEmp = procentEmp; }

    public int getEstimation() { return estimation; }
    public void setEstimation(int estimation) { this.estimation = estimation; }


}
