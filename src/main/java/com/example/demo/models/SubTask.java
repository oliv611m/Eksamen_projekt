package com.example.demo.models;

public class SubTask {
    private int sub_task_id;
    private String name;
    private String description;
    private int estimation;
    private String procentDays;
    private String procentHours;
    private String procentPrices;
    private String procentEmp;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getEstimation() { return estimation; }
    public void setEstimation(int estimation) { this.estimation = estimation; }

    public String getProcentDays() { return procentDays; }
    public void setProcentDays(String procentDays) { this.procentDays = procentDays; }

    public String getProcentHours() { return procentHours; }
    public void setProcentHours(String procentHours) { this.procentHours = procentHours; }

    public String getProcentPrices() { return procentPrices; }
    public void setProcentPrices(String procentPrices) { this.procentPrices = procentPrices; }

    public String getProcentEmp() { return procentEmp; }
    public void setProcentEmp(String procentEmp) { this.procentEmp = procentEmp; }

    public int getSub_task_id() { return sub_task_id; }
    public void setSub_task_id(int sub_task_id) { this.sub_task_id = sub_task_id; }
}
