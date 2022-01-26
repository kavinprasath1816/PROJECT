package com.oams.portal.service.serviceImplementation;

import java.util.HashSet;
import java.util.Set;

import com.oams.portal.dao.StudentRepo;
import com.oams.portal.exceptions.BasicExceptions;
import com.oams.portal.models.Student;
import com.oams.portal.models.StudentInput;
import com.oams.portal.service.FileStorageService;
import com.oams.portal.service.SRegisterService;

import org.apache.ibatis.builder.BuilderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class SRegistreImp implements SRegisterService{

    @Autowired
    StudentRepo repo;

    @Autowired
    FileStorageService fileStorageService;

    @Override
    public String addStudent(StudentInput student) {
        try{
            Student s = new Student(student);
            Set<String> role = new HashSet<String>();
            role.add("student");
            s.setRole(role);
            s.setImageFileName(fileStorageService.saveImg(student.getImage()));
            s.setTenFileName(fileStorageService.saveFile(student.getMarkSheetTen()));
            s.setTwelveFileName(fileStorageService.saveFile(student.getMarkSheet()));
            repo.save(s);
            return "done";
        }
        catch(Exception e){
            throw new BuilderException("Error in add student - "+e.getMessage());
        }
    }

    @Override
    public String getFileLocation(MultipartFile file) {
        try{
            String fileName = fileStorageService.saveFile(file);
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
            return fileDownloadUri;
        }
        catch(Exception e){
            throw new BasicExceptions("Error in get file location" + e.getMessage());
        }
    }


    
}
