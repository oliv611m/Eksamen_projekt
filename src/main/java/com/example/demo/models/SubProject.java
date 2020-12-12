package com.example.demo.models;

public class SubProject {
    private String subProjectName;
    private String procentDays;
    private String procentHours;
    private String procentPrices;
    private String procentEmp;
    private int estimation;

    public SubProject(){}

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
