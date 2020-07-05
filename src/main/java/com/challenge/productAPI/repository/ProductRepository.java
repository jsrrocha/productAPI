package com.challenge.productAPI.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.challenge.productAPI.model.Product;

public interface ProductRepository extends MongoRepository<Product, Integer> {
	public List<Product> findByNameLike(String name);
}
