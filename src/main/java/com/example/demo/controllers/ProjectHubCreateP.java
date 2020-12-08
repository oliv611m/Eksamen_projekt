package com.example.demo.controllers;

import com.example.demo.models.project;
import com.example.demo.services.ProjectCalculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjectHubCreateP {

    @GetMapping("/OpretProjekt")
    public String OpretProjekt(Model model){
        model.addAttribute("OpretProjekt", new project());
        return "ProjectHubCreateP";
    }
    @PostMapping("/OpretProjekt")
    public String showResult(@ModelAttribute project OpretProjekt, Model model){
        model.addAttribute("OpretProjekt", OpretProjekt);
        return "ProjektVeiw";
    }
}