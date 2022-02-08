package com.oams.portal.service;

import com.oams.portal.models.StaffModel;
import org.springframework.web.multipart.MultipartFile;

public interface StaffService {

    void addStaff(StaffModel staffModel, MultipartFile staffImage);

    void updatePassword(String password,String name);

    void delete(String email );
}
