package com.oams.portal.controller;

import com.oams.portal.exceptions.BasicExceptions;
import com.oams.portal.models.StaffModel;
import com.oams.portal.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    StaffService staffService;

    @RequestMapping("/main-page")
    public ModelAndView adminMainPage(){
        return new ModelAndView("adminlog");
    }

    @RequestMapping("/staff-form")
    public String staff() {
        return "Staff Register";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/staff-register")
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
}