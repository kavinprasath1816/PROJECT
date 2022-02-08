package com.oams.portal.controller;

import com.oams.portal.dao.StudentRepo;
import com.oams.portal.exceptions.BasicExceptions;
import com.oams.portal.models.Password;
import com.oams.portal.projections.StudentView;
import com.oams.portal.service.EmailService;
import com.oams.portal.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

import static com.oams.portal.constants.Constants.SUCCESS_EMAIL;

@Controller
@RequestMapping("/staff")
@Slf4j
public class StaffController {

    @Autowired
    StudentRepo repo;

    @Autowired
    StaffService service;

    @Autowired
    EmailService emailService;


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
        try {
            emailService.sendMail(email, "Regarding..", SUCCESS_EMAIL);
            repo.updateSelected(email);
            return "redirect:/staff/acceptance-page";
        } catch (Exception e) {
            log.error("accept failed");
            return "redirect:/staff/acceptance-page";
        }
    }

    @RequestMapping(value = "/reject/{email}")
    @PreAuthorize("hasAnyAuthority('Staff','admin')")
    public String reject(@PathVariable("email") String email) {
        try {
            repo.updateRejected(email);
            emailService.sendMail(email, "Regarding..", "You are Rejected");
            return "redirect:/staff/acceptance-page";
        } catch (Exception e) {
            log.error("reject failed");
            return "redirect:/staff/acceptance-page";
        }
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
    public ModelAndView updatePage() {
        return new ModelAndView("staffupdate");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update-password")
    public String updatePassword(Password password, Principal p) {
        try {
            service.updatePassword(password.getPassword(), p.getName());
            return "redirect:update-page";
        } catch (Exception e) {
            log.error("error while updating password");
            return "redirect:update-page";
        }
    }

    @RequestMapping("/student-database")
    @PreAuthorize("hasAnyAuthority('Staff','admin')")
    public ModelAndView studentDatabase(Model model) {
        try {
            List<StudentView> student = repo.getStudents();
            model.addAttribute("student", student);
            return new ModelAndView("studentshow");
        } catch (Exception e) {
            log.error("error while  showing student database");
            return new ModelAndView("studentshow");
        }
    }


}
