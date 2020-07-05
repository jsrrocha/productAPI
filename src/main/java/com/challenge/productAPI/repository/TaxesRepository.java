package com.challenge.productAPI.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.challenge.productAPI.model.Taxes;

public interface TaxesRepository extends MongoRepository<Taxes, Integer>{
	public List<Taxes> findByClientId(Integer clientId);
}
