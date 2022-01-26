package com.oams.portal.models;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "STUDENTS")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    public Student(StudentInput student) {
        this.name = student.getName();
        this.fatherName = student.getFatherName();
        this.email = student.getEmail();
        this.phoneNumber = student.getPhoneNumber();
        this.address = student.getAddress();
        this.dob = student.getDob();
        this.gender = student.getGender();
        this.password = student.getPassword();
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
    @Column(name = "image_path")
    private String imagePath;
    @Column(name = "twelve_path")
    private String twelvePath;
    @Column(name = "ten_path")
    private String tenPath;
    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;
    @UpdateTimestamp
    @Column(name="updated_at")
    private Timestamp updatedAt;

}
