package com.oams.portal.controller;

import com.oams.portal.dao.StudentRepo;
import com.oams.portal.exceptions.BasicExceptions;
import com.oams.portal.projections.StudentView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/staff")
@Slf4j
public class StaffController {

    @Autowired
    StudentRepo repo;


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
        return "redirect:/staff/acceptance-page";
    }

    @RequestMapping(value = "/reject/{email}")
    @PreAuthorize("hasAnyAuthority('Staff','admin')")
    public String reject(@PathVariable("email") String email) {
        repo.updateRejected(email);
        return "redirect:/staff/acceptance-page";
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
