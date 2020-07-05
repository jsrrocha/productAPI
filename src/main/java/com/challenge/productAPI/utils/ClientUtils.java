package com.challenge.productAPI.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.challenge.productAPI.model.Client;
import com.challenge.productAPI.service.ClientService;

@Component
public class ClientUtils {
	@Autowired
	private ClientService clientService;
	
	public ResponseEntity<?> clientValidation(Integer clientId) {
		Client client = clientService.findClientById(clientId);
		if (client == null) {
			return new ResponseEntity<String>("Cliente não encontrado", HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
