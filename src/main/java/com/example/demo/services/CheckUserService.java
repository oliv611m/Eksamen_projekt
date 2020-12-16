package com.example.demo.services;

import com.example.demo.models.UserIdentification;

import java.util.ArrayList;
import java.util.Random;

public class CheckUserService {

    private ArrayList<UserIdentification> list = new ArrayList<>();

    public UserIdentification checkUser(String cookieID){
        for(UserIdentification u : list){
            if(u.getCookieID().equals(cookieID)){
                return u;
            }
        }
        return null;
    }

    public void removeUserIdentification(String cookieID){
        UserIdentification userIden = null;
        for(UserIdentification u : list){
            if(u.getCookieID().equals(cookieID)){
                userIden = u;
            }
        }
        if (userIden != null){
            list.remove(userIden);
        }
    }

    public void removeUserIdentification(int corpID){
        for(UserIdentification u : list){
            if(u.getCorpID() == corpID){
                list.remove(u);
                break;
            }
        }
    }

    public UserIdentification createUserIdentification(int corpID, boolean empID){
        int cookieIDSize = 40;
        String cookieID = createCookieID(cookieIDSize);
        UserIdentification userIdentification = new UserIdentification(cookieID,corpID,empID);
        list.add(userIdentification);
        return userIdentification;
    }

    //Makes a String with chars from alphabet, size parameter
    public String createCookieID(int cookieIDSize){
        String alphabet = "0123456789aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
        String res = "";
        Random rand = new Random();
        int alphabetSize = alphabet.length();
        for(int i = 0; i < cookieIDSize; i++){
            res += alphabet.charAt(rand.nextInt(alphabetSize));
        }
        return res;
    }
}
