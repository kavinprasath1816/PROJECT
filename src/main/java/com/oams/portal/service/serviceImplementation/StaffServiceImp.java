package com.oams.portal.service.serviceImplementation;

import com.oams.portal.dao.StaffRepo;
import com.oams.portal.exceptions.BasicExceptions;
import com.oams.portal.models.StaffInput;
import com.oams.portal.models.StaffModel;
import com.oams.portal.service.FileStorageService;
import com.oams.portal.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class StaffServiceImp implements StaffService {

    @Autowired
    FileStorageService fileStorageService;

    @Autowired
    StaffRepo repo;

    @Override
    public void addStaff(StaffInput staffInput) {

        try {
            StaffModel staff = new StaffModel(staffInput);
            try {
                staff.setImageName(fileStorageService.saveImg(staffInput.getStaffImage()));
                Set<String> role = new HashSet<>();
                role.add("Staff");
                staff.setRole(role);
            } catch (IOException e) {
                throw new BasicExceptions("Error in adding Image");
            }
            repo.save(staff);

        }
        catch(Exception e){
            throw new BasicExceptions("Error in adding Staff");
        }

    }
}
