//Amir, Oliver
package com.example.demo.repositories;

import com.example.demo.models.Project;
import com.example.demo.services.ProjectCalculator;

import java.sql.*;

public class ProjectRepository {
    private Connection connection;
    ProjectCalculator calculator = new ProjectCalculator();

    public boolean setConnection(){
        boolean bres = false;
        String url = "jdbc:mysql://localhost:3306/pkv1?serverTimezone=UTC";
        try{
            connection = DriverManager.getConnection(url,"pkv_server","pkv_server");
            bres = true;
        }
        catch (SQLException e){
            System.out.println("No connection to server="+e.getMessage());
        }
        return bres;
    }

    public int createProject(String projectName, String description, String startDay, String endDay, int dayPrice,
                             int numberOfemp, int totalPrice, int workingDays, int workingHour){
        String insertStatement = "INSERT INTO project(name, day_price, total_Price, start_date, end_date, decription, days, hours, numbers_Ofemp) VALUES (?,?,?,?,?,?,?,?,?)";
        int project_id = -1;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setString(1,projectName);
            preparedStatement.setInt(2,dayPrice);
            preparedStatement.setString(3, String.valueOf(totalPrice));
            preparedStatement.setString(4,startDay);
            preparedStatement.setString(5,endDay);
            preparedStatement.setString(6,description);
            preparedStatement.setInt(7,workingDays);
            preparedStatement.setString(8, String.valueOf(workingHour));
            preparedStatement.setString(9, String.valueOf(numberOfemp));

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println("Project creation failed="+e.getMessage());
        }
        return project_id;
    }

    public int createSubProject(String subProjectName, String procentDays, String procentHours, String procentPrices, String procentEmp, String description){
        String insertStatement = "INSERT INTO sub_project(name, days, hours, employees, price, description) VALUES (?,?,?,?,?,?)";
        int sub_project_id = -1;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setString(1,subProjectName);
            preparedStatement.setString(2,procentDays);
            preparedStatement.setString(3,procentHours);
            preparedStatement.setString(4,procentEmp);
            preparedStatement.setString(5,procentPrices);
            preparedStatement.setString(6,description);

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println("SubProject creation failed="+e.getMessage());
        }
        return sub_project_id;
    }

    public int createTask(String name, double procentDays, double procentHours, double procentPrices, String description) {
        String insertStatement = "INSERT INTO task(name, days, hours, price, description) VALUES (?,?,?,?,?)";
        int task_id = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, String.valueOf(procentDays));
            preparedStatement.setString(3, String.valueOf(procentHours));
            preparedStatement.setString(4, String.valueOf(procentPrices));
            preparedStatement.setString(5, description);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Task creation failed=" + e.getMessage());
        }
        return task_id;
    }

    public int createSubTask(String name, double procentDays, double procentHours, double procentPrices, String description){
        String insertStatement = "INSERT INTO sub_task(name, days, hours, price, description) VALUES(?,?,?,?,?)";
        int sub_task_id =-1;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, String.valueOf(procentDays));
            preparedStatement.setString(3, String.valueOf(procentHours));
            preparedStatement.setString(4, String.valueOf(procentPrices));
            preparedStatement.setString(5, description);

            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            System.out.println("SubTask creation failed=" + e.getMessage());
        }
        return sub_task_id;
    }

    public ProjectRepository deleteProject(int projectID){
        String deleteStatement = "DELETE FROM project WHERE project_id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteStatement);
            preparedStatement.setInt(1,projectID);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println("Failed to delete project="+e.getMessage());
        }
        return null;
    }

}
