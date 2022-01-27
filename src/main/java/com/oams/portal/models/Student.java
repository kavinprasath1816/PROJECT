package com.oams.portal.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@ToString
@Table(name = "STUDENTS")
@Entity
public class Student {

    public Student(StudentInput student) {
        this.name = student.getName();
        this.fatherName = student.getFatherName();
        this.email = student.getEmail();
        this.phoneNumber = student.getPhoneNumber();
        this.address = student.getAddress();
        this.dob = student.getDob();
        this.gender = student.getGender();
        this.schoolTwelve = student.getSchoolTwelve();
        this.boardTwelve = student.getBoardTwelve();
        this.group = student.getGroup();
        this.markTwelve = student.getMarkTwelve();
        this.schoolTen = student.getSchoolTen();
        this.boardTen = student.getBoardTen();
        this.markTen = student.getMarkTen();
    }
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "ROLES",joinColumns = @JoinColumn(name = "id"))
    private Set<String> role; 
    @Column(name = "name")
    private String name;
    @Column(name = "father_name")
    private String fatherName;
    @Email
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "dob")
    private Date dob;
    @Column(name = "gender")
    private String gender;
    @Column(name = "password")
    private String password;
    @Column(name = "school_twelve")
    private String schoolTwelve;
    @Column(name = "board_twelve")
    private String boardTwelve;
    @Column(name = "group")
    private String group;
    @Column(name = "markTwelve")
    private String markTwelve;
    @Column(name = "school_ten")
    private String schoolTen;
    @Column(name = "board_ten")
    private String boardTen;
    @Column(name = "mark_ten")
    private String markTen;
    @Column(name = "image_file_name")
    private String imageFileName;
    @Column(name = "twelve_file_name")
    private String twelveFileName;
    @Column(name = "ten_file_name")
    private String tenFileName;
    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;
    @UpdateTimestamp
    @Column(name="updated_at")
    private Timestamp updatedAt;

}
