package com.example.demo.controllers;

import com.example.demo.models.Project;
import com.example.demo.services.ProjectCalculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjectHubCreateP {

    @GetMapping("/OpretProjekt")
    public String showProjectCreationPage(Model model){
        model.addAttribute("project", new Project());
        return "ProjectHubCreateP";
    }

    @PostMapping("/OpretProjekt")
    public String createProject(@ModelAttribute Project project, Model model){
        ProjectCalculator calculator = new ProjectCalculator();

        int workingDays = calculator.getWorkingDays(project.getStartDay(), project.getEndDay());
        project.setWorkingDays(workingDays);
        int workingHours = calculator.getWorkingHours(workingDays);
        project.setWorkingHours(workingHours);
        int totalPrice = calculator.getTotalPrice(workingDays, project.getDayPrice());
        project.setTotalPrice(totalPrice);

        model.addAttribute("project", project);
        return "ProjectView";
    }
}