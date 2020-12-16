package com.example.demo.models;

public class Task {
    private int task_id;
    private String name;
    private String description;
    private int estimation;
    private String procentDays;
    private String procentHours;
    private String procentPrices;
    private String procentEmp;


    public String getProcentDays() { return procentDays; }
    public void setProcentDays(String procentDays) { this.procentDays = procentDays; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getEstimation() { return estimation; }
    public void setEstimation(int estimation) { this.estimation = estimation; }

    public String getProcentHours() { return procentHours; }
    public void setProcentHours(String procentHours) { this.procentHours = procentHours; }

    public String getProcentPrices() { return procentPrices; }
    public void setProcentPrices(String procentPrices) { this.procentPrices = procentPrices; }

    public String getProcentEmp() { return procentEmp; }
    public void setProcentEmp(String procentEmp) { this.procentEmp = procentEmp; }

    public int getTask_id() { return task_id; }
    public void setTask_id(int task_id) { this.task_id = task_id; }
}
