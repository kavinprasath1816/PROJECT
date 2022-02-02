package com.oams.portal.service;

import com.oams.portal.models.Student;
import org.springframework.web.multipart.MultipartFile;

public interface SRegisterService {

    public void addStudent(Student student,MultipartFile img,MultipartFile file1,MultipartFile file2);

    public String getFileLocation(MultipartFile file);



    
    
}
