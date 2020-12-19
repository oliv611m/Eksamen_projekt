package com.example.demo.services;

import com.example.demo.models.Corporation;
import com.example.demo.repositories.ProfileRepository;
import org.springframework.ui.ModelMap;

public class RegistrationService {

    private ProfileRepository jdbc;

    public RegistrationService() {
        jdbc = new ProfileRepository();
        jdbc.setConnection();
    }

    public int createProfile(String name, String mail, String password, int CVR_no) {
        return jdbc.createProfile(name, mail, password, CVR_no);
    }

    public void getCorporation(int corpID, ModelMap modelMap){
        Corporation corporation = jdbc.getUserInfo(corpID);

        if (corporation == null){
            modelMap.addAttribute("errorMessage", "Kunne ikke finde din profil");
        }
        else {
            modelMap.addAttribute("corporation", corporation);
        }
    }

    public boolean checkRegistration(String name, String mail, String password){
        boolean b = true;
        if (name == null || name.length() > 150){
            b = false;
        }
        else if(mail == null || mail.length() > 256){
            b = false;
        }
        else if(password == null || password.length() > 150){
            b = false;
        }
        return b;
    }

    public void deleteProfile(int corpID, ModelMap modelMap){
        ProfileRepository deleteProfile = jdbc.deleteProfile(corpID);

        if (deleteProfile == null){
            modelMap.addAttribute("errorMessage", "Kunne ikke slette din profil");
        }
        else{
            modelMap.addAttribute("deleteProfile", deleteProfile);
        }
    }
}
