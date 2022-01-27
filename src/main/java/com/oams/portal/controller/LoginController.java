package com.oams.portal.controller;

import com.oams.portal.models.LoginModel;
import com.oams.portal.service.loginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    loginService lService;

    @RequestMapping(value = {"student/login"})
    public String login(){
        return "login form";
    }

    @RequestMapping(method =RequestMethod.POST,value="/student/login")
    @ResponseBody
    public String studentLogin(LoginModel lModel){
        return lService.studentLogin(lModel);
    }

    @RequestMapping("staff/login")
    @ResponseBody
    public String staffLogin(LoginModel model){
        return lService.staffLogin(model);
    }
    
}
