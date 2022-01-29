package com.oams.portal.service.serviceImplementation;

import com.oams.portal.dao.StudentRepo;
import com.oams.portal.exceptions.BasicExceptions;
import com.oams.portal.models.Student;
import com.oams.portal.service.FileStorageService;
import com.oams.portal.service.SRegisterService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.builder.BuilderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class SRegistreImp implements SRegisterService{

    @Autowired
    StudentRepo repo;

    @Autowired
    FileStorageService fileStorageService;

    @Override
    public void addStudent(Student student,MultipartFile img,MultipartFile file1, MultipartFile file2) {
        try{

            Set<String> role = new HashSet<>();
            role.add("student");
            student.setRole(role);
            student.setImageFileName(fileStorageService.saveImg(img));
            student.setTenFileName(fileStorageService.saveFile(file1));
            student.setTwelveFileName(fileStorageService.saveFile(file2));
            student.setPassword(BCrypt.hashpw(student.getPassword(), BCrypt.gensalt()));
            repo.save(student);
            log.info(student.getName()+" "+"student created successfully");
        }
        catch(Exception e){
            throw new BuilderException("Error in add student - ");
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
