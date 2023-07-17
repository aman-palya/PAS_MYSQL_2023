package com.cognizant.consumermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.consumermicroservice.model.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer,Long>{

}
