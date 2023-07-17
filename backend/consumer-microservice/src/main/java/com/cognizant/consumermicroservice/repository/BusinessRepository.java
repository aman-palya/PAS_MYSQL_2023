package com.cognizant.consumermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.consumermicroservice.model.Business;

@Repository
public interface BusinessRepository extends JpaRepository<Business,Double> {

}
