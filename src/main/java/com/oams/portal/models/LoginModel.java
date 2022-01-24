package com.oams.portal.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginModel {

    private String name;
    private String password;
    
}
