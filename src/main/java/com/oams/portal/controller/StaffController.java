package com.oams.portal.controller;

import com.oams.portal.exceptions.BasicExceptions;
import com.oams.portal.models.StaffInput;
import com.oams.portal.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StaffController {

    @Autowired
    StaffService staffService;

    @RequestMapping("staff")
    public String staff(){
        return "Staff Register";
    }

    @RequestMapping(method = RequestMethod.POST , value = "/staff/register")
    public String staffRegister(StaffInput staffInput){
        try {
            staffService.addStaff(staffInput);
            return "login form";
        }
        catch (Exception e)
        {
            throw new BasicExceptions(e.getMessage());
        }
    }


}
