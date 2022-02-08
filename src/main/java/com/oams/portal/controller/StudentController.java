package com.oams.portal.controller;


import com.oams.portal.dao.StudentRepo;
import com.oams.portal.exceptions.BasicExceptions;
import com.oams.portal.models.Address;
import com.oams.portal.models.Password;
import com.oams.portal.models.Phone;
import com.oams.portal.models.Student;
import com.oams.portal.service.SRegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


@Controller
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @Autowired
    SRegisterService service;

    @Autowired
    StudentRepo repo;


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
            throw new BasicExceptions("Error in register" + e.getMessage());
        }
        return "redirect:/student";
    }

    @RequestMapping("/main-page")
    @PreAuthorize("hasAuthority('student')")
    public ModelAndView studentMainPage(Model model, Principal p) {
        String message = "YOUR FORM IS STILL PENDING";
        if (repo.Selected(p.getName()))
            message = "YOUR FORM IS SELECTED";
        if (repo.Rejected(p.getName()))
            message = "YOUR FORM IS REJECTED";
        model.addAttribute("message", message);
        return new ModelAndView("studentlog");
    }

    @RequestMapping("/update-page")
    @PreAuthorize("hasAuthority('student')")
    public ModelAndView updatePage() {
        return new ModelAndView("studentupdate");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update-phone")
    @PreAuthorize("hasAuthority('student')")
    public String updatePhone(Phone phone, Principal p) {
        try {
            service.updatePhone(phone.getNumber(), p.getName());
            log.info("Phone Number Updated for " + p.getName());
            return "redirect:update-page";
        } catch (Exception e) {
            throw new BasicExceptions("Error in update phone Number");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update-address")
    @PreAuthorize("hasAuthority('student')")
    public String updateAddress(Address address, Principal p) {
        try {
            service.updateAddress(address.getAddress(), p.getName());
            log.info("Address Updated for " + p.getName());
            return "redirect:update-page";
        } catch (Exception e) {
            throw new BasicExceptions("Error in update Address");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update-password")
    @PreAuthorize("hasAuthority('student')")
    public String updatePassword(Password password, Principal p) {
        try {
            service.updatePassword(password.getPassword(), p.getName());
            log.info("Password Updated for " + p.getName());
            return "redirect:update-page";
        } catch (Exception e) {
            throw new BasicExceptions("Error in Password");
        }
    }
}
