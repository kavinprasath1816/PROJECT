package com.oams.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLOutput;

@Controller
public class MainController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = {"/","/home"})
    public ModelAndView home(){
        return new ModelAndView("home");
    }

    @RequestMapping("student/hello")
    @PreAuthorize("hasAuthority('student')")
    public ModelAndView hello() {
        return new ModelAndView("heloo");
    }

    @RequestMapping("/common")
    @PreAuthorize("hasAuthority('student')")
    public ModelAndView common() {
        return new ModelAndView("normal");
    }
}
