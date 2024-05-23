package com.opnapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opnapp.models.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

}
