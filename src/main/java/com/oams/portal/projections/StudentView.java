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
    public String groupTwelve;
    public String phoneNumber;
    public String gender;
    public String imageFileName;
    public String schoolTwelve;
    public String boardTwelve;
    public  Date dob;
    public int markTwelve;
    public String schoolTen;
    public String boardTen;
    public int markTen;
    public Timestamp createdAt;
}
