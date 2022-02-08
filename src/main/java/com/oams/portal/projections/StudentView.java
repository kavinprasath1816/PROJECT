package com.oams.portal.projections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentView {
    public String name;
    public String email;
    public String group_twelve;
    public String phone_number;
    public String gender;
    public String image_file_name;
    public String school_twelve;
    public String board_twelve;
    public  Date dob;
    public int mark_twelve;
    public String school_ten;
    public String board_ten;
    public int mark_ten;
    public Timestamp created_at;
}
