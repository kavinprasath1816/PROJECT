package com.oams.portal.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping("/staff/main")
    @PreAuthorize("hasAuthority('staff')")
    public ModelAndView Index(){
        return new ModelAndView("main");
    }

    @RequestMapping("student/hello")
    @PreAuthorize("hasAuthority('student')")
    public ModelAndView hello(){
        return new ModelAndView("heloo");
    }

    @RequestMapping("/common")
    @PreAuthorize("hasAuthority('student')")
    public ModelAndView common(){ return new ModelAndView("normal");}
}
