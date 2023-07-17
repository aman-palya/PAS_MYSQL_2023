package com.cognizant.quotesmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.quotesmicroservice.model.QuotesMaster;

@Repository
public interface QuotesMasterRepository extends JpaRepository<QuotesMaster,Integer> {

	QuotesMaster findByBusinessValueAndPropertyValue(double bValue, double pValue);
}
