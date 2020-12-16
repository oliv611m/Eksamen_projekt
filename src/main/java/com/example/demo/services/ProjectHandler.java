package com.example.demo.services;

import com.example.demo.repositories.ProjectRepository;

public class ProjectHandler {
    private ProjectRepository jdbc;

    public ProjectHandler(){
        jdbc = new ProjectRepository();
        jdbc.setConnection();
    }
    public int createProject(String ProjectName, String description, String startDay, String endDay, int dayPrice,
                             int numberOfemp, int totalPrice, int workingDays, int workingHour){
        return jdbc.createProject(ProjectName, description, startDay, endDay, dayPrice, numberOfemp, totalPrice, workingDays, workingHour);
    }
}
