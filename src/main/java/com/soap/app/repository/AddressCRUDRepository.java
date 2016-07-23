package com.soap.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soap.app.model.AddressModel;

@Repository
public interface AddressCRUDRepository extends JpaRepository<AddressModel, Long> {

}
