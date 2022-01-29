package com.oams.portal.controller;

import com.oams.portal.models.LoginModel;
import com.oams.portal.service.loginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value="/student")
    public ModelAndView student(){
        return new ModelAndView("login");
    }

    @RequestMapping(value="/student/login")
    public ModelAndView studentLogin(){
        return new ModelAndView("heloo");
    }

    @RequestMapping(value="/staff")
    public ModelAndView staff(){
        return new ModelAndView("login");
    }

    @RequestMapping(value="/staff/login")
    public ModelAndView staffLogin(){
        return new ModelAndView("main");
    }

    
}
