//Amir
package com.example.demo.models;

public class SubProject {
    private int sub_project_id;
    private String subProjectName;
    private String procentDays;
    private String procentHours;
    private String procentPrices;
    private String procentEmp;
    private int estimation;
    private String description;



    public SubProject(){}

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

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

    public int getSub_project_id() { return sub_project_id; }
    public void setSub_project_id(int sub_project_id) { this.sub_project_id = sub_project_id;}
}
