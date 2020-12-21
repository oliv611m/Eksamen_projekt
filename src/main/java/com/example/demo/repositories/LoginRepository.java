//Oliver
package com.example.demo.repositories;

import java.sql.*;

public class LoginRepository {
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

    //LoginService
    public int getCorpFromLogin(String mail, String password){
        String selectStatement =
                "SELECT corp_id FROM corporation " +
                        "WHERE mail = ? AND password = ?";
        int corpID = -1;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);
            preparedStatement.setString(1, mail);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            corpID = resultSet.getInt("corp_id");
        }
        catch (SQLException e){
            System.out.println("Retrieving corpID from login failed="+e.getMessage());
        }
        return corpID;
    }
    public boolean getEmpFromLogin(String email, String password){
        String selectStatement =
                "SELECT emp_id FROM employee " +
                        "WHERE email = ? AND password = ?";
        boolean empID = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                empID = true;
            }
        }
        catch (SQLException e){
            System.out.println("Retrieving empID from login failed="+e.getMessage());
        }
        return empID;
    }

}
