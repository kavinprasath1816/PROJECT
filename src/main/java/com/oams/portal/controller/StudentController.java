package com.oams.portal.controller;


import com.oams.portal.models.StudentInput;

import com.oams.portal.service.SRegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class StudentController {

    @Autowired
    SRegisterService service;


    @RequestMapping(value="/student")
    public String studentRegister()
    {
        return "Student Register";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/student/register")
    public String register(StudentInput student){
        service.addStudent(student);
        return "login form";
    }

    
}
