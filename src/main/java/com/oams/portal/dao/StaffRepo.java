package com.oams.portal.dao;

import com.oams.portal.models.StaffModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepo extends JpaRepository<StaffModel,Integer> {

    @Query(value = "SELECT * FROM STAFF WHERE EMAIL = ?1",nativeQuery = true)
    Optional<StaffModel> loadByEmail(String name);

    @Query(value = "SELECT COUNT(*) FROM STAFF",nativeQuery = true)
    int getCount();

    @Modifying
    @Query(value = "UPDATE STAFF SET PASSWORD = ?1  WHERE EMAIL = ?2",nativeQuery = true)
    void updatePassword(String password,String name);

    @Query(value = "SELECT * FROM STAFF",nativeQuery = true)
    List<StaffModel> getStaff();

    @Query(value = "SELECT * FROM STAFF WHERE EMAIL = ?1",nativeQuery = true)
    StaffModel staff(String email);
}
