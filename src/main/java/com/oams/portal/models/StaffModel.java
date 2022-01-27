package com.oams.portal.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


@Table(name = "STAFF")
@Data
public class StaffModel {

    private String staffName;
    private String staffEmail;
    private String ImageName;
    private String password;
}
