//Oliver
package com.example.demo.repositories;

import com.example.demo.models.Corporation;
import java.sql.*;


public class ProfileRepository {
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

    public int createProfile(String mail, String name, String password, int CVR_no){
        String insertStatement = "INSERT INTO corporation (mail, name, password, CVR_no) VALUES ( ? , ? , ?, ?)";
        int corpID = -1;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setString(1, mail);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, String.valueOf(CVR_no));

            preparedStatement.executeUpdate();

        }
        catch (SQLException e){
            System.out.println("Profile creation failed="+e.getMessage());
        }
        //t(''t)
        return corpID;
    }

    public Corporation getUserInfo(int corpID){
        ResultSet res = null;
        String selectSQL =
                "SELECT * FROM corporation " +
                        "WHERE corp_id = ?";

        String name = null;
        String password = null;
        int CVR_no = -1;
        String mail = null;
        int corporationID = -1;

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, corpID);
            res =preparedStatement.executeQuery();
            res.next();

            name = res.getString("name");
            password = res.getString("password");
            CVR_no = res.getInt("CVR_no");
            mail = res.getString("mail");
            corpID = res.getInt("corp_id");

        }
        catch (SQLException e){
            System.out.println("GetUserInfoError="+e.getMessage());
        }

        Corporation corporation = new Corporation(name, CVR_no, mail, password, corporationID);
        return corporation;
    }

    public ProfileRepository deleteProfile(int corpID){
        String deleteStatement = "DELETE FROM corporation WHERE corp_id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteStatement);
            preparedStatement.setInt(1,corpID);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println("Failed to delete profile="+e.getMessage());
        }
        return null;
    }

}
