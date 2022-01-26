package com.oams.portal.models;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Roles {
    private String role;
    
}
