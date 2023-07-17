package com.cognizant.consumermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.consumermicroservice.model.BusinessMaster;

@Repository
public interface BusinessMasterRepository extends JpaRepository<BusinessMaster,Integer> {
	
	
}
