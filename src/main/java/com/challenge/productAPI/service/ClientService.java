package com.challenge.productAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.productAPI.model.Client;
import com.challenge.productAPI.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	public Client findClientById(Integer clientId) {
		return clientRepository.findByIdCliente(clientId);
	}
}
