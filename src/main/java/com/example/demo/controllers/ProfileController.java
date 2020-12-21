package com.example.demo.controllers;

import com.example.demo.models.UserIdentification;
import com.example.demo.services.CheckUserService;
import com.example.demo.services.LoginService;
import com.example.demo.services.RegistrationService;
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
    RegistrationService registrationService;

    public ProfileController(){
        checkUserService = new CheckUserService();
        loginService = new LoginService();
        registrationService = new RegistrationService();
    }

    @GetMapping("/login")
    public String login(@CookieValue(value = "cookieID", defaultValue = "") String cookieID, HttpServletResponse response, ModelMap modelMap){
        UserIdentification userIden = checkUserService.checkUser(cookieID);
        if(userIden == null){
            return "login";
        }
        else if(userIden.isEmpID()){
            return "redirect:OpretProjekt";
        }
        else if(userIden.getCorpID() > 0){
            return "redirect:OpretProjekt";
        }
        return "login";
    }

    //UserIdentifying
    @GetMapping("/logout")
    public String logOut(@CookieValue(value = "cookieID", defaultValue = "") String cookieID, HttpServletResponse response, ModelMap modelMap){
        checkUserService.removeUserIdentification(cookieID);
        return "redirect:login";
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
            return "redirect:OpretProjekt";
        }
        else{
            int corpID = loginService.getCorpID(mail,password);
            if(corpID > 0){
                userIden = checkUserService.createUserIdentification(corpID,false);
                Cookie cookie = new Cookie("cookieID",userIden.getCookieID());
                cookie.setMaxAge(2592000);
                response.addCookie(cookie);
                return "redirect:profile";
            }
        }
        modelMap.addAttribute("errorMessage","Forkert Brugernavn eller Kodeord");
        return "redirect:login";
    }

    @GetMapping("/")
    public String index(@CookieValue(value = "cookieID", defaultValue = "") String cookieID, HttpServletResponse response, ModelMap modelMap){
        return "redirect:login";
    }

    //UserIdentifying
    @GetMapping("/register")
    public String register(@CookieValue(value = "cookieID", defaultValue = "") String cookieID, HttpServletResponse response, ModelMap modelMap){
        UserIdentification userIden = checkUserService.checkUser(cookieID);
        if(userIden == null){
            return  "register";
        }
        else if(userIden.isEmpID()){
            return "redirect:profile";
        }
        else if(userIden.getCorpID() > 0){
            return "redirect:profile";
        }
        return "register";
    }

    //UserIdentifying
    @PostMapping("/registrationRequest")
    public String registrationRequest(@CookieValue(value = "cookieID", defaultValue = "") String cookieID, HttpServletResponse response, ModelMap modelMap, WebRequest webRequest){
        String mail = webRequest.getParameter("mail");
        String name = webRequest.getParameter("name");
        String password = webRequest.getParameter("password");
        int CVR_no = Integer.parseInt(webRequest.getParameter("CVR_no"));
        UserIdentification userIden = checkUserService.checkUser(cookieID);
        if(userIden == null || registrationService.checkRegistration(mail, name, password)){
            int corpID = registrationService.createProfile(mail, name, password, CVR_no);
            if(corpID > 0){
                userIden = checkUserService.createUserIdentification(corpID, false);
                Cookie cookie = new Cookie("cookieID", userIden.getCookieID());
                cookie.setMaxAge(2592000);
                response.addCookie(cookie);
                return "redirect:OpretProjekt";
            }
            else{
                return "redirect:login";
            }
        }
        else if(userIden.isEmpID()){
            return "redirect:profile";
        }
        return "redirect:OpretProjekt";
    }

    //Profile
    @GetMapping("/profile")
    public String profile(@CookieValue(value = "cookieID", defaultValue = "") String cookieID, HttpServletResponse response, ModelMap modelMap, WebRequest request){
        UserIdentification userIden = checkUserService.checkUser(cookieID);
        if(userIden == null){
            return "redirect:login";
        }
        else if(userIden.isEmpID()){
            int corpID = Integer.parseInt(request.getParameter("profileID"));
            registrationService.getCorporation(corpID, modelMap);
            return "profile";
        }
        else if(userIden.getCorpID() < 0){
            return "redirect:login";
        }
        registrationService.getCorporation(userIden.getCorpID(), modelMap);
        modelMap.addAttribute("userIden", userIden);
        return "profile";
    }

    //Profile
    @PostMapping("/deleteProfile")
    public String deleteProfile(@CookieValue(value = "cookieID", defaultValue = "") String cookieID, HttpServletResponse response, ModelMap modelMap, WebRequest request){
        UserIdentification userIden = checkUserService.checkUser(cookieID);
        if(userIden == null){
            return "redirect:login";
        }
        registrationService.deleteProfile(userIden.getCorpID(), modelMap);
        checkUserService.removeUserIdentification(userIden.getCookieID());
        return "redirect:login";
    }

}
