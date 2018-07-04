package com.xapi.rate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xapi.rate.entity.Rates;

@Repository
public interface RateRepository extends JpaRepository<Rates, String>{
	
}
