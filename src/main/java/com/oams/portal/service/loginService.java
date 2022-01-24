package com.oams.portal.service;

import com.oams.portal.models.LoginModel;

public interface loginService {
    
    String studentLogin(LoginModel model);
    String staffLogin(LoginModel model);

}
