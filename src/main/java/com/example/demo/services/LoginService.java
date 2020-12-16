package com.example.demo.services;

import com.example.demo.repositories.LoginRepository;

public class LoginService {

    private LoginRepository jdbc;

    public LoginService() {
        jdbc = new LoginRepository();
        jdbc.setConnection();
    }

    public int getCorpID(String mail, String password){
        return jdbc.getCorpFromLogin(mail,password);
    }

    public boolean checkEmpID(String email, String password){
        return jdbc.getEmpFromLogin(email,password);
    }
}