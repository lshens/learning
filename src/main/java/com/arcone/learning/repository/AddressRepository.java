package com.arcone.learning.repository;

import com.arcone.learning.model.AddressPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<AddressPO, String> {

    Optional<AddressPO> findByUserId(String userId);
}
