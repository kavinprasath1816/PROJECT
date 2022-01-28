package com.oams.portal.models;

import lombok.*;
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
@NoArgsConstructor
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
    private int id;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "ROLES", joinColumns = @JoinColumn(name = "id"))
    private Set<String> role;
    @Column(name = "NAME")
    private String name;
    private String fatherName;
    @Email
    private String email;
    private String phoneNumber;
    private String address;
    private Date dob;
    private String gender;
    private String password;
    private String schoolTwelve;
    private String boardTwelve;
    private String group;
    private String markTwelve;
    private String schoolTen;
    private String boardTen;
    private String markTen;
    private String imageFileName;
    private String twelveFileName;
    private String tenFileName;
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;

}
