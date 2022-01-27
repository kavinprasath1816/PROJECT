package com.oams.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaffCotroller {

    @RequestMapping("/staff")
    public String staff(){
        return "Staff Register";
    }


}
