package com.oams.portal.dao;

import com.oams.portal.models.StaffModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepo extends JpaRepository<StaffModel,Integer> {
}
