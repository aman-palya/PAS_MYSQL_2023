package com.cognizant.policymicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.policymicroservice.model.PolicyMaster;

@Repository
public interface PolicyMasterRepository extends JpaRepository<PolicyMaster,Long> {

	PolicyMaster findByPvalueAndBvalue(double pvalue,double bvalue);
}
