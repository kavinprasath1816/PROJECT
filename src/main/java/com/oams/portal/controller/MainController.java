package com.oams.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class MainController {

    @RequestMapping("/index")
    public String Index(){
        return "Index";
    }
}
