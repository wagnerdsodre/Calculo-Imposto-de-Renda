package com.serviceberkan.impostos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.serviceberkan.impostos.domain.Salary;

@Repository
public interface SalaryRepository extends MongoRepository<Salary, String>  {

	
	
}
