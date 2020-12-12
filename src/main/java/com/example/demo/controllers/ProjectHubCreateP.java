package com.example.demo.controllers;

import com.example.demo.models.Project;
import com.example.demo.models.SubProject;
import com.example.demo.services.ProjectCalculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjectHubCreateP {
    private Project project;

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

        this.project = project;

        model.addAttribute("project", project);
        return "ProjectView";
    }

    @GetMapping("/OpretSubProject")
        public String showSubProjectCreationPage(Model model){
        model.addAttribute("subProject", new SubProject());
        return "SubProject";
        }

    @PostMapping("/OpretSubProject")
    public String createSubProject(@ModelAttribute SubProject subProject, Model model){
        ProjectCalculator calculator = new ProjectCalculator();

        String procentDays = calculator.getProcent(subProject.getEstimation(), this.project.getWorkingDays());
        subProject.setProcentDays(procentDays);

        String procentHours = calculator.getProcent(subProject.getEstimation(), this.project.getWorkingHours());
        subProject.setProcentHours(procentHours);

        String procentPric = calculator.getProcent(subProject.getEstimation(), this.project.getTotalPrice());
        subProject.setProcentPrices(procentPric);

        String procentEmp = calculator.getProcent(subProject.getEstimation(), this.project.getNumberOfemp());
        subProject.setProcentEmp(procentEmp);

        model.addAttribute("subProject", subProject);
        return "SubProjectView";
    }

}
