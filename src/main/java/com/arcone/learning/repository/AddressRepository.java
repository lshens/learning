package com.arcone.learning.repository;

import com.arcone.learning.model.AddressPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressPO, String> {

    AddressPO findByUserId(String userId);
}
