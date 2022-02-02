package com.oams.portal.controller;

import com.oams.portal.dao.StudentRepo;
import com.oams.portal.exceptions.BasicExceptions;
import com.oams.portal.models.StaffModel;
import com.oams.portal.projections.StudentView;
import com.oams.portal.service.FileStorageService;
import com.oams.portal.service.SRegisterService;
import com.oams.portal.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/staff")
@Slf4j
public class StaffController {

    @Autowired
    StaffService staffService;

    @Autowired
    FileStorageService fileStorageService;

    @Autowired
    StudentRepo repo;

    @Autowired
    SRegisterService service;


    @RequestMapping("/acceptance-page")
    @PreAuthorize("hasAnyAuthority('Staff','admin')")
    public ModelAndView Index(Model model) {
        try {
            List<StudentView> student = repo.getAllStudents();
            model.addAttribute("student", student);
            return new ModelAndView("main");
        } catch (Exception e) {
            log.error("Error in getting list of students");
            throw new BasicExceptions("Error in getting list of students");
        }
    }

    @RequestMapping(value = "/accept/{email}")
    @PreAuthorize("hasAnyAuthority('Staff','admin')")
    public String accept(@PathVariable("email") String email) {
        repo.updateSelected(email);
        return "redirect:/staff/main";
    }

    @RequestMapping(value = "/reject/{email}")
    @PreAuthorize("hasAnyAuthority('Staff','admin')")
    public String reject(@PathVariable("email") String email) {
        repo.updateRejected(email);
        return "redirect:/staff/main";
    }

    @RequestMapping("/selected-mark")
    @PreAuthorize("hasAnyAuthority('Staff','admin')")
    public ModelAndView mark(Model model) {
        try {
            List<StudentView> student = repo.getSelectedStudentsMark();
            model.addAttribute("student", student);
            return new ModelAndView("main");
        } catch (Exception e) {
            log.error("Error in getting list of students");
            throw new BasicExceptions("Error in getting list of students");
        }
    }

    @RequestMapping("/sort-name")
    @PreAuthorize("hasAnyAuthority('Staff','admin')")
    public ModelAndView name(Model model) {
        try {
            List<StudentView> student = repo.getOrderByName();
            model.addAttribute("student", student);
            return new ModelAndView("main");
        } catch (Exception e) {
            log.error("Error in getting list of students");
            throw new BasicExceptions("Error in getting list of students");
        }
    }

    @RequestMapping("/sort-mark")
    @PreAuthorize("hasAnyAuthority('Staff','admin')")
    public ModelAndView r_name(Model model) {
        try {
            List<StudentView> student = repo.getOrderByMark();
            model.addAttribute("student", student);
            return new ModelAndView("main");
        } catch (Exception e) {
            log.error("Error in getting list of students");
            throw new BasicExceptions("Error in getting list of students");
        }
    }

    @RequestMapping("/rejected-mark")
    @PreAuthorize("hasAnyAuthority('Staff','admin')")
    public ModelAndView hi(Model model) {
        try {
            List<StudentView> student = repo.getRejectedStudentsMark();
            model.addAttribute("student", student);
            return new ModelAndView("main");
        } catch (Exception e) {
            log.error("Error in getting list of students");
            throw new BasicExceptions("Error in getting list of students");
        }
    }

    @RequestMapping("/main-page")
    @PreAuthorize("hasAnyAuthority('Staff','admin')")
    public ModelAndView staffMainPage() {
        return new ModelAndView("stafflog");
    }

    @RequestMapping("/update-page")
    @PreAuthorize("hasAuthority('Staff')")
    public ModelAndView updatePage(){
        return new ModelAndView("staffupdate");
    }


}
