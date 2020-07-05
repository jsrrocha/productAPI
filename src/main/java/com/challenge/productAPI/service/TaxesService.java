package com.challenge.productAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.productAPI.model.Taxes;
import com.challenge.productAPI.repository.TaxesRepository;

@Service
public class TaxesService {
	@Autowired
	private TaxesRepository taxesRepository;
	
	public List<Taxes> findTaxesOfClient(Integer clientId) {
		return taxesRepository.findByClientId(clientId); 
	}
}
