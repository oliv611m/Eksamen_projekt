//Amir, Oliver
package com.example.demo.services;

import com.example.demo.repositories.ProjectRepository;
import org.springframework.ui.ModelMap;

public class ProjectHandler {
    private ProjectRepository jdbc;

    public ProjectHandler(){
        jdbc = new ProjectRepository();
        jdbc.setConnection();
    }

    public int createProject(String projectName, String description, String startDay, String endDay, int dayPrice,
                             int numberOfemp, int totalPrice, int workingDays, int workingHour){
        return jdbc.createProject(projectName, description, startDay, endDay, dayPrice, numberOfemp, totalPrice, workingDays, workingHour);
    }

    public int createSubProject(String subProjectName, String procentDays, String procentHours, String procentPrices, String procentEmp, String description){
        return jdbc.createSubProject(subProjectName, procentDays, procentHours, procentPrices, procentEmp, description);
    }

    public int createTask(String name, double procentDays, double procentHours, double procentPrices, String description){
        return jdbc.createTask(name, procentDays, procentHours, procentPrices, description);
    }

    public int createSubTask(String name, double procentDays, double procentHours, double procentPrices, String description){
        return jdbc.createSubTask(name, procentDays, procentHours, procentPrices, description);
    }


    public void deleteProject(int projectID, ModelMap modelMap){
        ProjectRepository deleteProject = jdbc.deleteProject(projectID);

        if (deleteProject == null){
            modelMap.addAttribute("errorMessage", "Kunne ikke slette dit projekt");
        }
        else{
            modelMap.addAttribute("deleteProject", deleteProject);
        }
    }
}
