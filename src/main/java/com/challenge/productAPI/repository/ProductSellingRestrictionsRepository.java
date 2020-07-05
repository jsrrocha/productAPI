package com.challenge.productAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.challenge.productAPI.model.ProductSellingRestrictions;

public interface ProductSellingRestrictionsRepository extends MongoRepository<ProductSellingRestrictions, Integer>{
	public ProductSellingRestrictions findByIdClienteAndIdProduto(Integer idCliente, Integer idProduto); 
}
