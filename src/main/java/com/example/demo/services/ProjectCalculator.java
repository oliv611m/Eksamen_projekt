package com.example.demo.services;

import com.example.demo.models.Project;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class ProjectCalculator {
    public ProjectCalculator() {

    }
/*
Skal der oprettes en metode kun til at tage imod info omkring projektet eller er det fint at
modellen sender oplysninger herhen.
 */
    public void NumberOfDays() {
        Scanner scan = new Scanner(System.in);
        Project project = new Project();
        System.out.println("Enter the name of your project");
        project.setProjectName(scan.nextLine());
        System.out.println("Enter start day");
        project.setStartDay(scan.next());
        System.out.println("Enter end day");
        project.setEndDay(scan.next());

        int workingDays = getWorkingDays(project.getStartDay(), project.getEndDay());
        project.setWorkingDays(workingDays);

        System.out.println(project.getWorkingDays() + " days");
        project.setWorkingHours(project.getWorkingDays() * 7);
        System.out.println(project.getWorkingHours() + " hours");
        System.out.println("Enter number of employee you will have on this project");
        project.setNumberOfemp(scan.nextInt());
        System.out.println("Enter your day price");
        project.setDayPrice(scan.nextInt());

        project.setTotalPrice(project.getDayPrice() * project.getWorkingHours());
        System.out.println("your total price is " + project.getTotalPrice() + "kr");

        /*
        Skal det her rykkes ud i en metode for sig selv?
         */
        boolean stop = false;
        String creatSubProject = "";
        while (!stop) {
            System.out.println("Do you wont to make a sub project? Answer with yes or no");
            creatSubProject = scan.next();
            if(creatSubProject.equals("yes")) {
                System.out.println("Breake it down to sub projects\nName your sub project");
                project.setSubProject(scan.next());
                System.out.println("you name it " + project.getSubProject());
                System.out.println("How much of your time do you estimate to use on this sub project");
                int estimate = scan.nextInt();

                String procentDays = getProcent(estimate, project.getWorkingDays());
                String procentHours = getProcent(estimate, project.getWorkingHours());
                String procentPrices = getProcent(estimate, project.getTotalPrice());
                String procentEmp = getProcent(estimate, project.getNumberOfemp());


                System.out.println(estimate + "% of " + project.getWorkingDays() + " days is " + procentDays + "days");
                System.out.println(estimate + "% of " + project.getWorkingHours() + " hours is " + procentHours + "hours");
                System.out.println(estimate + "% of " + project.getTotalPrice() + " price is " + procentPrices + "kr");
                System.out.println(estimate + "% of " + project.getNumberOfemp() + " you have approximately " + procentEmp +
                        " employees on this project");
                System.out.println("Do wont to make another sub project");
            } else if(creatSubProject.equals("no")){
                stop = true;
            }
        }

    }


    public String getProcent(double procent, double number) {
        DecimalFormat df = new DecimalFormat("##.##");
        double amount = (procent/100)*number;
        return df.format(amount);
    }

    public int getWorkingDays(String startDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        int workingDays = 0;
        try {
            Calendar start = Calendar.getInstance();
            start.setTime(sdf.parse(startDate));
            Calendar end = Calendar.getInstance();
            end.setTime(sdf.parse(endDate));
            while (!start.after(end)) {
                int day = start.get(Calendar.DAY_OF_WEEK);
                if ((day != Calendar.SATURDAY) && (day != Calendar.SUNDAY))
                    workingDays++;
                start.add(Calendar.DATE, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workingDays;
    }

    public int getWorkingHours(int workingDays) {
        return workingDays * 7;
    }

    public int getTotalPrice(int days, int dayPrice) {
        return days * dayPrice;
    }

}
