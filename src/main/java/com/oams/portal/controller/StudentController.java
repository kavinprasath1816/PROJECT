package com.oams.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping(value="/student")
    public String studentRegister()
    {
        return "Student Register";
    }

    
}
