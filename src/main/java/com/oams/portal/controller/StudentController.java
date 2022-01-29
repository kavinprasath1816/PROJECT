package com.oams.portal.controller;


import com.oams.portal.exceptions.BasicExceptions;
import com.oams.portal.models.Student;
import com.oams.portal.service.SRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    SRegisterService service;


    @RequestMapping(value = "/form")
    public ModelAndView studentRegister() {
        return new ModelAndView("Student Register");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String register(Student student, @RequestBody MultipartFile image,
                           @RequestBody MultipartFile markSheet,
                           @RequestBody MultipartFile markSheetTen) {
        try {
            service.addStudent(student, image, markSheet, markSheetTen);
        } catch (Exception e) {
            throw new BasicExceptions("Error in register");
        }
        return "redirect:login";
    }


}
