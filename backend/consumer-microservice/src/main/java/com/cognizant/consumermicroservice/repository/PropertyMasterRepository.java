package com.cognizant.consumermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.consumermicroservice.model.PropertyMaster;

@Repository
public interface PropertyMasterRepository extends JpaRepository<PropertyMaster,Integer> {
	
}
