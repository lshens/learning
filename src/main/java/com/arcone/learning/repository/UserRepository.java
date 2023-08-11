package com.arcone.learning.repository;

import com.arcone.learning.model.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserPO, String> {
}
