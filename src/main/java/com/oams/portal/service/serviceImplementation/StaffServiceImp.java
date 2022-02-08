package com.oams.portal.service.serviceImplementation;

import com.oams.portal.dao.StaffRepo;
import com.oams.portal.exceptions.BasicExceptions;
import com.oams.portal.models.StaffModel;
import com.oams.portal.service.FileStorageService;
import com.oams.portal.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class StaffServiceImp implements StaffService {

    @Autowired
    FileStorageService fileStorageService;

    @Autowired
    StaffRepo repo;

    @Override
    public void addStaff(StaffModel staffModel, MultipartFile file) {

        try {
            try {
                staffModel.setImageName(fileStorageService.saveImg(file));
                Set<String> role = new HashSet<>();
                role.add("Staff");
                staffModel.setRole(role);
                staffModel.setPassword(BCrypt.hashpw(staffModel.getPassword(), BCrypt.gensalt()));
            } catch (IOException e) {
                throw new BasicExceptions("Error in adding Image");
            }
            repo.save(staffModel);
            log.info(staffModel.getStaffName() + " " + "staff created successfully");

        } catch (Exception e) {
            throw new BasicExceptions("Error in adding Staff");
        }

    }
    @Transactional
    @Override
    public void updatePassword(String password,String name){
        repo.updatePassword(BCrypt.hashpw(password, BCrypt.gensalt()),name);
    }

    @Override
    public void delete(String email){
        try {
            StaffModel staff = repo.staff(email);
            repo.deleteById(staff.getStaffId());
            log.info("Staff deleted successfully!");
        }
        catch(Exception e){
            log.error("Staff cannot be deleted");
        }
    }


}
