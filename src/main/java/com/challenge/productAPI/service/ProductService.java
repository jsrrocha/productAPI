package com.challenge.productAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.productAPI.model.Product;
import com.challenge.productAPI.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	 /* 
	 * Achei vários jeitos de fazer um like aqui: Com @Query e regex uma linha acima
	 * ou também usando o método .findByRegexpName("");
	 * Mas esse que usei parece ser mais intuitivo e funciona como o like do SQL
	 */ 
	public List<Product> findProductsByNameLike(String name) {
		return productRepository.findByNameLike(name);
	}

}
