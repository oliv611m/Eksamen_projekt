package com.example.demo.controllers;

import com.example.demo.models.Project;
import com.example.demo.models.SubProject;
import com.example.demo.models.SubTask;
import com.example.demo.models.Task;
import com.example.demo.repositories.ProjectRepository;
import com.example.demo.services.ProjectCalculator;
import com.example.demo.services.ProjectHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectHubCreateP {
    ProjectHandler projectHandler;
    private Project project;
    private List<SubProject> subProjects = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();
    private List<SubTask> subTasks = new ArrayList<>();

    @GetMapping("/OpretProjekt")
    public String showProjectCreationPage(Model model){
        model.addAttribute("project", new Project());
        return "ProjectHubCreateP";
    }

    @PostMapping("/OpretProjekt")
    public String createProject(@ModelAttribute Project project, Model model, WebRequest webRequest){
        ResultSet resultSet;
        ProjectCalculator calculator = new ProjectCalculator();
        /*


        int workingDays = calculator.getWorkingDays(project.getStartDay(),project.getEndDay());
        project.setWorkingDays(workingDays);

        int workingHours = calculator.getWorkingHours(workingDays);
        project.setWorkingHours(workingHours);

        int totalPrice = calculator.getTotalPrice(workingDays, project.getDayPrice());
        project.setTotalPrice(totalPrice);


         */
        String ProjectName = webRequest.getParameter("ProjectName");
        String description = webRequest.getParameter("description");
        String startDay = webRequest.getParameter("startDay");
        String endDay = webRequest.getParameter("endDay");
        int numberOfemp = Integer.parseInt(webRequest.getParameter("numberOfemp"));
        int dayPrice = Integer.parseInt(webRequest.getParameter("dayPrice"));

        int workingDays = calculator.getWorkingDays(startDay,endDay);
        int workingHours = calculator.getWorkingHours(workingDays);
        int totalPrice = calculator.getTotalPrice(workingDays,dayPrice);

        int project_id = projectHandler.createProject(ProjectName,description,startDay,endDay,dayPrice,numberOfemp,totalPrice,workingHours,workingDays);



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

        this.subProjects.add(subProject);
        model.addAttribute("subProject", subProject);
        return "SubProjectView";
    }

    @GetMapping("/OpretTask")
    public String showTask(Model model){
        model.addAttribute("task", new Task());
        return "TaskCreate";
    }

    @PostMapping("/OpretTask")
    public String createTask(@ModelAttribute Task task, Model model){

        ProjectCalculator calculator = new ProjectCalculator();

        double procentDays = calculator.getDoubleFromString(this.subProjects.get(0).getProcentDays());
        String procentDaysToString = calculator.getProcent(task.getEstimation(), procentDays);
        task.setProcentDays(procentDaysToString);


        double procentHours = calculator.getDoubleFromString(this.subProjects.get(0).getProcentHours());
        String procentHoursToString = calculator.getProcent(task.getEstimation(), procentHours);
        task.setProcentHours(procentHoursToString);

        double procentPrice = calculator.getDoubleFromString(this.subProjects.get(0).getProcentPrices());
        String procentPriceToString = calculator.getProcent(task.getEstimation(), procentPrice);
        task.setProcentPrices(procentPriceToString);

        double procentEmp = calculator.getDoubleFromString(this.subProjects.get(0).getProcentEmp());
        String procentEmpToString = calculator.getProcent(task.getEstimation(), procentEmp);
        task.setProcentEmp(procentEmpToString);


        this.tasks.add(task);
        model.addAttribute("task",task);
        return "TaskView";
    }

    @GetMapping("/OpretSubTask")
    public String showSubTask(Model model){
        model.addAttribute("subTask", new SubTask());
        return "subTaskCreate";
    }

    @PostMapping("/OpretSubTask")
    public String createSubTask(@ModelAttribute SubTask subTask, Model model){
        ProjectCalculator calculator = new ProjectCalculator();

        double procentDays = calculator.getDoubleFromString(this.tasks.get(0).getProcentDays());
        String procentDaysToString = calculator.getProcent(subTask.getEstimation(),procentDays);
        subTask.setProcentDays(procentDaysToString);

        double procentHours = calculator.getDoubleFromString(this.tasks.get(0).getProcentHours());
        String procentHoursToString = calculator.getProcent(subTask.getEstimation(), procentHours);
        subTask.setProcentHours(procentHoursToString);

        double procentPrice = calculator.getDoubleFromString(this.tasks.get(0).getProcentPrices());
        String procentPriceToString = calculator.getProcent(subTask.getEstimation(),procentPrice);
        subTask.setProcentPrices(procentPriceToString);

        double procentEmp = calculator.getDoubleFromString(this.tasks.get(0).getProcentEmp());
        String procentEmpToString = calculator.getProcent(subTask.getEstimation(), procentEmp);
        subTask.setProcentEmp(procentEmpToString);

        this.subTasks.add(subTask);
        model.addAttribute("subTask",subTask);
        return "subTaskView";
    }


    @GetMapping("/project")
    public String showFullProject(Model model) {
        model.addAttribute("project", project);
        model.addAttribute("subProjects", subProjects);
        model.addAttribute("tasks", tasks);
        model.addAttribute("subTasks", subTasks);
        return "FullProjectView";
    }

}
