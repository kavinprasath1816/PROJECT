package com.oams.portal.dao;

import com.oams.portal.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentJpaRepo extends JpaRepository<Student,Integer> {

    @Query(value = "SELECT * FROM STUDENTS WHERE EMAIL = ?1",nativeQuery = true)
    Optional<Student> loadByEmail(String name);
}
