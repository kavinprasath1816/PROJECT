package com.oams.portal.dao;

import com.oams.portal.models.StaffModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepo extends JpaRepository<StaffModel,Integer> {

    @Query(value = "SELECT * FROM STAFF WHERE EMAIL = ?1",nativeQuery = true)
    Optional<StaffModel> loadByEmail(String name);

    @Query(value = "SELECT COUNT(*) FROM STAFF",nativeQuery = true)
    int getCount();
}
