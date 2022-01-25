package com.oams.portal.service;

import com.oams.portal.models.StudentInput;

import org.springframework.web.multipart.MultipartFile;

public interface SRegisterService {

    public String addStudent(StudentInput student);

    public String getFileLocation(MultipartFile file);

    
    
}
