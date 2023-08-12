package com.arcone.learning.repository;

import com.arcone.learning.model.UserRolePO;
import com.arcone.learning.model.UserRolePOId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRolePO, UserRolePOId> {
}
