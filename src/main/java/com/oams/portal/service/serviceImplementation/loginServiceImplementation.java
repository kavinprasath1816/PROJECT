package com.oams.portal.service.serviceImplementation;

import com.oams.portal.models.LoginModel;
import com.oams.portal.service.loginService;

import org.springframework.stereotype.Service;

@Service
public class loginServiceImplementation implements loginService{

    @Override
    public String studentLogin(LoginModel model){
        if (model.getName().equalsIgnoreCase("Krithik"))
            return "sucess";
        return "failed";

    }

    @Override
    public String staffLogin(LoginModel model) {
        if (model.getName().equalsIgnoreCase("staff"))
            return "sucess";
        return "failed";
    }

    
}
