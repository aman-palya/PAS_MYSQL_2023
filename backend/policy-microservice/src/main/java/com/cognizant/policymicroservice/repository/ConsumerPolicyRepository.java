package com.cognizant.policymicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.policymicroservice.model.ConsumerPolicy;

@Repository
public interface ConsumerPolicyRepository extends JpaRepository<ConsumerPolicy,Long> {

	ConsumerPolicy findByConsumeridAndBusinessid(Long consumer,double business);
	
	ConsumerPolicy findByConsumerid(Long id);
}
