package com.challenge.productAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.challenge.productAPI.model.Client;

public interface ClientRepository extends MongoRepository<Client, Integer> {
	public Client findByIdCliente(Integer idCliente);
}
