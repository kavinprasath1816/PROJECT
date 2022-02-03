package com.oams.portal.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@Table(name = "STUDENTS")
@NoArgsConstructor
@Entity
public class Student {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "ROLES", joinColumns = @JoinColumn(name = "id"))
    private Set<String> role;
    @Column(name = "NAME")
    private String name;
    @Column(name = "FATHER")
    private String fatherName;
    @Email
    @Column(name = "EMAIL",unique = true)
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "DOB")
    private Date dob;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "SCHOOL_TWELVE")
    private String schoolTwelve;
    @Column(name = "BOARD_TWELVE")
    private String boardTwelve;
    @Column(name = "GROUP_TWELVE")
    private String group;
    @Column(name = "MARK_TWELVE")
    private String markTwelve;
    @Column(name = "SCHOOL_TEN")
    private String schoolTen;
    @Column(name = "BOARD_TEN")
    private String boardTen;
    @Column(name = "MARK_TEN")
    private String markTen;
    @Column(name = "IMAGE_FILE_NAME")
    private String imageFileName;
    @Column(name = "TWELVE_FILE_NAME")
    private String twelveFileName;
    @Column(name = "TEN_FILE_NAME")
    private String tenFileName;
    @CreationTimestamp
    @Column(name = "CREATED_AT")
    private Timestamp createdAt = Timestamp.from(Instant.now());
    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    private Timestamp updatedAt = Timestamp.from(Instant.now());
    @Column(name = "SELECTED")
    private boolean selected=false;
    @Column(name = "REJECTED")
    private boolean rejected=false;

}
