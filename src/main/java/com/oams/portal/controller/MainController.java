package com.oams.portal.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping("/staff/index")
    public ModelAndView Index(){
        return new ModelAndView("Index");
    }

    @RequestMapping("student/hello")
    public ModelAndView hello(){
        return new ModelAndView("heloo");
    }
}
