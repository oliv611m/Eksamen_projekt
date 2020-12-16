package com.example.demo.controllers;

import com.example.demo.models.UserIdentification;
import com.example.demo.services.CheckUserService;
import com.example.demo.services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProfileController {

    CheckUserService checkUserService;
    LoginService loginService;

    public ProfileController(){
        checkUserService = new CheckUserService();
        loginService = new LoginService();
    }

    @GetMapping("/login")
    public String login(@CookieValue(value = "cookieID", defaultValue = "") String cookieID, HttpServletResponse response, ModelMap modelMap){
        UserIdentification userIden = checkUserService.checkUser(cookieID);
        if(userIden == null){
            return "login";
        }
        else if(userIden.isEmpID()){
            return "redirect:login";
        }
        else if(userIden.getCorpID() > 0){
            return "redirect:login";
        }
        return "login";
    }

    //UserIdentifying
    @PostMapping("/loginRequest")
    public String loginRequest(@CookieValue(value = "cookieID", defaultValue = "") String cookieID, HttpServletResponse response, ModelMap modelMap, WebRequest webRequest){
        String mail = webRequest.getParameter("mail");
        String email = webRequest.getParameter("email");
        String password = webRequest.getParameter("password");
        UserIdentification userIden = null;
        if(loginService.checkEmpID(email,password)){
            userIden = checkUserService.createUserIdentification(-1, true);
            Cookie cookie = new Cookie("cookieID",userIden.getCookieID());
            cookie.setMaxAge(2592000);
            response.addCookie(cookie);
            return "redirect:login";
        }
        else{
            int corpID = loginService.getCorpID(mail,password);
            if(corpID > 0){
                userIden = checkUserService.createUserIdentification(corpID,false);
                Cookie cookie = new Cookie("cookieID",userIden.getCookieID());
                cookie.setMaxAge(2592000);
                response.addCookie(cookie);
                return "redirect:OpretProject";
            }
        }
        modelMap.addAttribute("errorMessage","Forkert Brugernavn eller Kodeord");
        return "redirect:login";
    }

    @GetMapping("/")
    public String index(@CookieValue(value = "cookieID", defaultValue = "") String cookieID, HttpServletResponse response, ModelMap modelMap){
        return "redirect:login";
    }

}
