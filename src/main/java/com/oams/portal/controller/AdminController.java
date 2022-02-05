package com.oams.portal.controller;

import com.oams.portal.dao.StaffRepo;
import com.oams.portal.dao.StudentRepo;
import com.oams.portal.exceptions.BasicExceptions;
import com.oams.portal.models.StaffModel;
import com.oams.portal.projections.StudentView;
import com.oams.portal.service.SRegisterService;
import com.oams.portal.service.StaffService;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    StaffService staffService;

    @Autowired
    StudentRepo repo;

    @Autowired
    StaffRepo staffRepo;

    @Autowired
    SRegisterService service;

    @RequestMapping(value = {"/main-page","/admin-dashboard"})
    public ModelAndView adminMainPage(Model model){
        model.addAttribute("student",repo.getCount());
        model.addAttribute("staff",staffRepo.getCount());
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
            return "redirect:admin-dashboard";
        } catch (BasicExceptions e) {
            model.addAttribute("error", "Email has already Taken");
            return "Staff Register";
        } catch (Exception e) {
            System.out.println("hitting");
            model.addAttribute("error", "Email has already Taken");
            return "Staff Register";
        }

    }

    @RequestMapping("/staff-database")
    @PreAuthorize("hasAnyAuthority('admin')")
    public ModelAndView staffDatabase(Model model){
        List<StaffModel> staff = staffRepo.getStaff();
        model.addAttribute("staff",staff);
        return new ModelAndView("staffshow");
    }

    @RequestMapping(method = RequestMethod.GET,value = "/delete-user/{email}")
    public String delete(@PathVariable("email") String email){
        service.delete(email);
        return "redirect:/staff/student-database";
    }

    @RequestMapping(method = RequestMethod.GET,value="/delete-staff/{email}")
    public String staffDelete(@PathVariable("email") String email){
        staffService.delete(email);
        return "redirect:/admin/staff-database";
    }
}
