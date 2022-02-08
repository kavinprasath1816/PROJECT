package com.oams.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = "/student")
    public ModelAndView student() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/staff")
    public ModelAndView staff() {
        return new ModelAndView("login");
    }


}
