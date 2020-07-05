package com.challenge.productAPI.utils;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.challenge.productAPI.model.Product;

@Component
public class ProductUtils {
	public ResponseEntity<?> productValidation(List<Product> products) {
		if(products == null || products.isEmpty()) {
			return new ResponseEntity<String>("Não foram encontrados produtos para essa pesquisa", HttpStatus.BAD_REQUEST);
		}
		return null;
	}	
}
