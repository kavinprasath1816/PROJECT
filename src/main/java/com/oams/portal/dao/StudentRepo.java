package com.oams.portal.dao;

import com.oams.portal.models.Student;
import com.oams.portal.projections.StudentView;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.MappedTypes;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Mapper
@MappedTypes(Student.class)
public interface StudentRepo {

    @Insert("INSERT INTO STUDENTS ( ADDRESS, BOARD_TEN , BOARD_TWELVE , CREATED_AT , DOB , EMAIL , FATHER , " +
            "GENDER , GROUP_TWELVE , IMAGE_FILE_NAME , MARK_TEN , MARK_TWELVE , NAME " +
            ", PASSWORD , PHONE_NUMBER , SCHOOL_TEN , SCHOOL_TWELVE , SELECTED , TEN_FILE_NAME , " +
            "TWELVE_FILE_NAME , UPDATED_AT , REJECTED ) VALUES ( #{address}, #{boardTen} , #{boardTwelve} , #{createdAt} , #{dob} , #{email} ," +
            " #{fatherName} , #{gender} , #{group} , " +
            "#{imageFileName} , #{markTen} , #{markTwelve} , #{name}" +
            " , #{password} , #{phoneNumber} , #{schoolTen} , " +
            "#{schoolTwelve} , #{selected} , #{tenFileName} , #{twelveFileName} , " +
            "#{updatedAt},#{rejected} )")
    void add(Student student);

    @Select("SELECT * FROM STUDENTS WHERE EMAIL = #{name}")
    Optional<Student> loadByEmail(String name);

    @Select("SELECT NAME,EMAIL,GROUP_TWELVE,PHONE_NUMBER,GENDER,IMAGE_FILE_NAME,SCHOOL_TWELVE," +
            "BOARD_TWELVE,DOB,MARK_TWELVE,SCHOOL_TEN,BOARD_TEN," +
            "MARK_TEN FROM STUDENTS WHERE SELECTED=FALSE AND REJECTED = FALSE")
    List<StudentView> getAllStudents();

    @Select("SELECT * FROM STUDENTS WHERE ID=#{id}")
    Optional<StudentView> getStudentById(int id);

    @Update("UPDATE STUDENTS SET SELECTED = TRUE, REJECTED = FALSE WHERE EMAIL = #{email}")
    void updateSelected(String email);

    @Update("UPDATE STUDENTS SET REJECTED = TRUE, SELECTED = FALSE WHERE EMAIL = #{email}")
    void updateRejected(String email);


    @Select("SELECT NAME,EMAIL,GROUP_TWELVE,PHONE_NUMBER,GENDER,IMAGE_FILE_NAME,SCHOOL_TWELVE," +
            "BOARD_TWELVE,DOB,MARK_TWELVE,SCHOOL_TEN,BOARD_TEN," +
            "MARK_TEN FROM STUDENTS WHERE SELECTED=FALSE AND REJECTED = FALSE ORDER BY NAME")
    List<StudentView> getOrderByName();

    @Select("SELECT NAME,EMAIL,GROUP_TWELVE,PHONE_NUMBER,GENDER,IMAGE_FILE_NAME,SCHOOL_TWELVE," +
            "BOARD_TWELVE,DOB,MARK_TWELVE,SCHOOL_TEN,BOARD_TEN," +
            "MARK_TEN FROM STUDENTS WHERE SELECTED=TRUE ORDER BY MARK_TWELVE")
    List<StudentView> getSelectedStudentsMark();

    @Select("SELECT NAME,EMAIL,GROUP_TWELVE,PHONE_NUMBER,GENDER,IMAGE_FILE_NAME,SCHOOL_TWELVE," +
            "BOARD_TWELVE,DOB,MARK_TWELVE,SCHOOL_TEN,BOARD_TEN," +
            "MARK_TEN FROM STUDENTS WHERE SELECTED=FALSE AND REJECTED=FALSE ORDER BY NAME")
    List<StudentView> getOrderByMark();

    @Select("SELECT NAME,EMAIL,GROUP_TWELVE,PHONE_NUMBER,GENDER,IMAGE_FILE_NAME,SCHOOL_TWELVE," +
            "BOARD_TWELVE,DOB,MARK_TWELVE,SCHOOL_TEN,BOARD_TEN," +
            "MARK_TEN FROM STUDENTS WHERE REJECTED=TRUE ORDER BY MARK_TWELVE")
    List<StudentView> getRejectedStudentsMark();

    @Update("UPDATE STUDENTS SET PHONE_NUMBER = #{number}, UPDATED_AT = #{time} WHERE EMAIL = #{name}")
    void updatePhoneNumber(String number, String name, Timestamp time);

    @Select("SELECT COUNT(*) FROM STUDENTS")
    int getCount();

    @Update("UPDATE STUDENTS SET ADDRESS = #{address}, UPDATED_AT = #{time} WHERE EMAIL = #{name}")
    void updateAddress(String address, String name, Timestamp time);

    @Update("UPDATE STUDENTS SET PASSWORD = #{password}, UPDATED_AT = #{time} WHERE EMAIL = #{name}")
    void updatePassword(String password, String name, Timestamp time);

    @Select("SELECT SELECTED FROM STUDENTS WHERE EMAIL = #{name}")
    boolean Selected(String name);

    @Select("SELECT REJECTED FROM STUDENTS WHERE EMAIL = #{name}")
    boolean Rejected(String name);

    @Select("SELECT NAME,EMAIL,GROUP_TWELVE,PHONE_NUMBER,GENDER,IMAGE_FILE_NAME,SCHOOL_TWELVE," +
            "BOARD_TWELVE,DOB,MARK_TWELVE,SCHOOL_TEN,BOARD_TEN," +
            "MARK_TEN,CREATED_AT FROM STUDENTS ORDER BY NAME")
    List<StudentView> getStudents();

    @Select("SELECT ID FROM STUDENTS WHERE EMAIL = #{name}")
    Integer getId(String email);




}
