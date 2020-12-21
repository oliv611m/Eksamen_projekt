//Amir
package com.example.demo.controllers;

import com.example.demo.models.*;
import com.example.demo.services.ProjectCalculator;
import com.example.demo.services.ProjectHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

    @Controller
    public class ProjectController {
        ProjectCalculator projectCalculator;
        ProjectHandler projectHandler;
        private Project project;
        private List<SubProject> subProjects = new ArrayList<>();
        private List<Task> tasks = new ArrayList<>();
        private List<SubTask> subTasks = new ArrayList<>();

        public ProjectController(){
            projectCalculator = new ProjectCalculator();
            projectHandler = new ProjectHandler();
        }

        @GetMapping("/OpretProjekt")
        public String showProjectCreationPage(Model model){
            model.addAttribute("project", new Project());
            return "ProjectHub";
        }

        @PostMapping("/OpretProjekt")
        public String createProject(@ModelAttribute Project project, Model model, WebRequest webRequest){
            ResultSet resultSet;
            ProjectCalculator calculator = new ProjectCalculator();

            String projectName = webRequest.getParameter("projectName");
            String description = webRequest.getParameter("description");
            String startDay = webRequest.getParameter("startDay");
            String endDay = webRequest.getParameter("endDay");

            int numberOfemp = Integer.parseInt(webRequest.getParameter("numberOfemp"));
            int dayPrice = Integer.parseInt(webRequest.getParameter("dayPrice"));

            int workingDays = projectCalculator.getWorkingDays(startDay,endDay);
            int workingHours = projectCalculator.getWorkingHours(workingDays);
            int totalPrice = projectCalculator.getTotalPrice(workingDays,dayPrice);

            int project_id = projectHandler.createProject(projectName,description,startDay,endDay,dayPrice,numberOfemp,totalPrice,workingHours,workingDays);


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
        public String createSubProject(@ModelAttribute SubProject subProject, Model model, WebRequest webRequest){
            ProjectCalculator calculator = new ProjectCalculator();

            String procentDays = calculator.getProcent(subProject.getEstimation(), this.project.getWorkingDays());
            subProject.setProcentDays(procentDays);

            String procentHours = calculator.getProcent(subProject.getEstimation(), this.project.getWorkingHours());
            subProject.setProcentHours(procentHours);

            String procentPrices = calculator.getProcent(subProject.getEstimation(), this.project.getTotalPrice());
            subProject.setProcentPrices(procentPrices);

            String procentEmp = calculator.getProcent(subProject.getEstimation(), this.project.getNumberOfemp());
            subProject.setProcentEmp(procentEmp);

            String subProjectName = webRequest.getParameter("subProjectName");
            String description = webRequest.getParameter("description");

            int sub_project_id = projectHandler.createSubProject(subProjectName, procentDays, procentHours, procentPrices, procentEmp, description);

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
        public String createTask(@ModelAttribute Task task, Model model, WebRequest webRequest){

            ProjectCalculator calculator = new ProjectCalculator();

            double procentDays = calculator.getDoubleFromString(this.subProjects.get(0).getProcentDays());
            String procentDaysToString = calculator.getProcent(task.getEstimation(), procentDays);
            task.setProcentDays(procentDaysToString);


            double procentHours = calculator.getDoubleFromString(this.subProjects.get(0).getProcentHours());
            String procentHoursToString = calculator.getProcent(task.getEstimation(), procentHours);
            task.setProcentHours(procentHoursToString);

            double procentPrices = calculator.getDoubleFromString(this.subProjects.get(0).getProcentPrices());
            String procentPriceToString = calculator.getProcent(task.getEstimation(), procentPrices);
            task.setProcentPrices(procentPriceToString);

            double procentEmp = calculator.getDoubleFromString(this.subProjects.get(0).getProcentEmp());
            String procentEmpToString = calculator.getProcent(task.getEstimation(), procentEmp);
            task.setProcentEmp(procentEmpToString);

            String name = webRequest.getParameter("name");
            String description = webRequest.getParameter("description");

            int task_id = projectHandler.createTask(name, procentDays, procentHours, procentPrices, description);

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
        public String createSubTask(@ModelAttribute SubTask subTask, Model model, WebRequest webRequest){
            ProjectCalculator calculator = new ProjectCalculator();

            double procentDays = calculator.getDoubleFromString(this.tasks.get(0).getProcentDays());
            String procentDaysToString = calculator.getProcent(subTask.getEstimation(),procentDays);
            subTask.setProcentDays(procentDaysToString);

            double procentHours = calculator.getDoubleFromString(this.tasks.get(0).getProcentHours());
            String procentHoursToString = calculator.getProcent(subTask.getEstimation(), procentHours);
            subTask.setProcentHours(procentHoursToString);

            double procentPrices = calculator.getDoubleFromString(this.tasks.get(0).getProcentPrices());
            String procentPriceToString = calculator.getProcent(subTask.getEstimation(),procentPrices);
            subTask.setProcentPrices(procentPriceToString);

            double procentEmp = calculator.getDoubleFromString(this.tasks.get(0).getProcentEmp());
            String procentEmpToString = calculator.getProcent(subTask.getEstimation(), procentEmp);
            subTask.setProcentEmp(procentEmpToString);

            String name = webRequest.getParameter("name");
            String description = webRequest.getParameter("description");

            int sub_task_id = projectHandler.createSubTask(name, procentDays, procentHours, procentPrices, description);

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

