package com.oams.portal.models;



import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInput {

    
    private String name;
    private String fatherName;
    private String email;
    private String phoneNumber;
    private String address;
    private Date dob;
    private String gender;
    private String password;
    private MultipartFile image;
    private String schoolTwelve;
    private String boardTwelve;
    private String group;
    private String markTwelve;
    private MultipartFile markSheet;
    private String schoolTen;
    private String markTen;
    private String boardTen;
    private MultipartFile markSheetTen;        
}
