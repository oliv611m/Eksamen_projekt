package com.example.demo.services;

import com.example.demo.models.Corporation;
import com.example.demo.repositories.LoginRepository;
import org.springframework.ui.ModelMap;

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