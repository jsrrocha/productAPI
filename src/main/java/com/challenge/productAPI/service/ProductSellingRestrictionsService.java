package com.challenge.productAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.challenge.productAPI.model.ProductSellingRestrictions;
import com.challenge.productAPI.repository.ProductSellingRestrictionsRepository;

@Service
public class ProductSellingRestrictionsService {
	@Autowired
	private ProductSellingRestrictionsRepository productSellingRestrictionsRepository;
	
	public ProductSellingRestrictions findByClientAndProduct(Integer clientId, Integer productId) {
		return productSellingRestrictionsRepository.findByIdClienteAndIdProduto(clientId, productId);
	}
}
