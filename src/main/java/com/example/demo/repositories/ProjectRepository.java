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

    public int createProject(String ProjectName, String description, String startDay, String endDay, int dayPrice,
                             int numberOfemp, int totalPrice, int workingDays, int workingHour){
        String insertStatement = "INSERT INTO project(name, day_price, start_date, end_date, decription, days, hours, numbers_ofEmp) VALUES (?,?,?,?,?,?,?,?,?)";
        int project_id = -1;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setString(1,ProjectName);
            preparedStatement.setString(2,description);
            preparedStatement.setString(3,startDay);
            preparedStatement.setString(4,endDay);
            preparedStatement.setInt(5,dayPrice);

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println("Profile creation failed="+e.getMessage());
        }
        return project_id;
    }

    public int createSubProject(int project_id){
        String insertStatement = "INSERT INTO sub_project(name, days, hours, employees, prices, project_id, decription) VALUES (?,?,?,?,?,?,?,?)";
        int sub_project_id = -1;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setString(1,"");
            preparedStatement.setInt(2,0);
            preparedStatement.setInt(3,0);
            preparedStatement.setInt(4,0);
            preparedStatement.setInt(5,0);
            preparedStatement.setInt(6,project_id);
            preparedStatement.setString(7,"");
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println("Profile creation failed="+e.getMessage());
        }
        return sub_project_id;
    }

    public int createTask(int sub_project_id) {
        String insertStatement = "INSERT INTO task(name, days, sub_project_id, hours, price, description) VALUES (?,?,?,?,?,?)";
        int task_id = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setString(1, "");
            preparedStatement.setInt(2, 0);
            preparedStatement.setInt(3, sub_project_id);
            preparedStatement.setInt(4, 0);
            preparedStatement.setInt(5, 0);
            preparedStatement.setString(6, "");
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Profile creation failed=" + e.getMessage());
        }
        return task_id;
    }

    public int createSubTask(int task_id){
        String insertStatement = "INSERT INTO sub_task(sub_task_id, name, days, task_id, hours, price, description) VALUES(?,?,?,?,?,?,?)";
        int sub_task_id =-1;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setString(1,"");
            preparedStatement.setInt(2,0);
            preparedStatement.setInt(3,0);
            preparedStatement.setInt(4,task_id);
            preparedStatement.setInt(5,0);
            preparedStatement.setInt(6,0);
            preparedStatement.setString(7,"");
        }catch (SQLException e) {
            System.out.println("Profile creation failed=" + e.getMessage());
        }
        return sub_task_id;
    }

}
