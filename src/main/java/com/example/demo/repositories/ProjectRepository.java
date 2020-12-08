package com.example.demo.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProjectRepository {
    private Connection connection;

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
}
