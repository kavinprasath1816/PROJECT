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


    @RequestMapping("/form")
    public String staff() {
        return "Staff Register";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String staffRegister(Model model, @Valid StaffModel staffModel, @RequestBody MultipartFile staffImage, BindingResult result) {

        try {
            staffService.addStaff(staffModel, staffImage);
            return "redirect:login";
        } catch (BasicExceptions e) {
            model.addAttribute("error", "Email has already Taken");
            return "Staff Register";
        } catch (Exception e) {
            System.out.println("hitting");
            model.addAttribute("error", "Email has already Taken");
            return "Staff Register";
        }

    }

    @RequestMapping("/main")
    @PreAuthorize("hasAuthority('Staff')")
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
    @PreAuthorize("hasAuthority('Staff')")
    public String accept(@PathVariable("email") String email) {
        repo.updateSelected(email);
        return "redirect:/staff/main";
    }

    @RequestMapping(value = "/reject/{email}")
    @PreAuthorize("hasAuthority('Staff')")
    public String reject(@PathVariable("email") String email) {
        repo.updateRejected(email);
        return "redirect:/staff/main";
    }

    @RequestMapping("/selected-mark")
    @PreAuthorize("hasAuthority('Staff')")
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

    @RequestMapping("/selected-name")
    @PreAuthorize("hasAuthority('Staff')")
    public ModelAndView name(Model model) {
        try {
            List<StudentView> student = repo.getAllStudents();
            model.addAttribute("student", student);
            return new ModelAndView("main");
        } catch (Exception e) {
            log.error("Error in getting list of students");
            throw new BasicExceptions("Error in getting list of students");
        }
    }

    @RequestMapping("/rejected-name")
    @PreAuthorize("hasAuthority('Staff')")
    public ModelAndView r_name(Model model) {
        try {
            List<StudentView> student = repo.getRejectedStudents();
            model.addAttribute("student", student);
            return new ModelAndView("main");
        } catch (Exception e) {
            log.error("Error in getting list of students");
            throw new BasicExceptions("Error in getting list of students");
        }
    }

    @RequestMapping("/rejected-mark")
    @PreAuthorize("hasAuthority('Staff')")
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
    @PreAuthorize("hasAuthority('Staff')")
    public ModelAndView staffMainPage() {
        return new ModelAndView("stafflog");
    }


}
