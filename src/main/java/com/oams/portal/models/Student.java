package com.oams.portal.models;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "STUDENT")
@Data
public class Student {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "father_name")
    private String fatherName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "school_twelve")
    private String schoolTwelve;
    @Column(name = "board_twelve")
    private String boardTwelve;
    @Column(name = "group")
    private String group;
    @Column(name = "mark_sheet")
    private File markSheet;
    @Column(name = "school_ten")
    private String schoolTen;
    @Column(name = "board_ten")
    private String boardTen;
    @Column(name = "image_path")
    private String imagePath;
}
