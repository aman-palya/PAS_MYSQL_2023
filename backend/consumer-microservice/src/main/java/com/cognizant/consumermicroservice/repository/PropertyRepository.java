package com.cognizant.consumermicroservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.consumermicroservice.model.Consumer;
import com.cognizant.consumermicroservice.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property,Integer> {


	Optional<Property> findByPid(int pid);
}
