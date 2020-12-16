package com.example.demo.services;

public class CheckUserInput {

    //Null if bad date
    public String checkDate(String year, String month, String day){
        //Checks if "valid" date
        //Returns formatted date or null
        try{
            int x = Integer.parseInt(year);
            x = Integer.parseInt(month);
            x = Integer.parseInt(day);
        }
        catch (NumberFormatException e){
            return null;
        }

        if (year.length() != 4){
            return null;
        }
        else if(month.length() > 2){
            return null;
        }
        else if(day.length() > 2){
            return null;
        }

        if(month.length() == 1){
            month = "0" + month;
        }
        if(day.length() == 1){
            day = "0" + day;
        }

        return year + "-" + month + "-" + day;
    }

    public boolean checkChangesToProfile(String firstname, String surname, String email, String username, String password, String description){
        boolean b = true;
        if(firstname == null || firstname.length() > 150){
            b = false;
        }
        else if (surname == null || surname.length() > 150){
            b = false;
        }
        else if (email == null || email.length() > 256){
            b = false;
        }
        else if (username == null || username.length() > 150){
            b = false;
        }
        else if(password == null || password.length() > 150){
            b = false;
        }
        else if(description == null || description.length() > 600){
            b = false;
        }
        return b;
    }
}