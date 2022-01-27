package com.oams.portal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffInput {

    private String staffName;
    private String staffEmail;
    private MultipartFile staffImage;
    private String password;

}
