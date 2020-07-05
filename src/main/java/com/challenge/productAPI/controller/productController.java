package com.challenge.productAPI.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.challenge.productAPI.model.Product;
import com.challenge.productAPI.model.ProductSellingRestrictions;
import com.challenge.productAPI.service.ProductSellingRestrictionsService;
import com.challenge.productAPI.service.ProductService;
import com.challenge.productAPI.utils.ClientUtils;
import com.challenge.productAPI.utils.ProductUtils;
import com.challenge.productAPI.utils.TaxesUtils;

@RestController
@RequestMapping("api/product")
public class productController {
	
	/*
	 * Minha estratégia aqui foi separar as regras de negócio da requisição. 
	 * Por isso, criei o util do produto e do cliente para validar as entradas da requisição. 
	 * No model Taxes não fazia sentido colocar o método de calculo dentro dele então também criei um utils. 
	 * No model do Produto coloquei a criação do Map de retorno.
	 * 
	 * Ia fazer com TDD, mas acabei fazendo direto e quando me toquei já era tarde e acabei deixando sem os testes automatizados.
	 * Mas testei pelo Postman manualmente usando mongoimport para importar os .csvs para o meu banco local.
	 * Tive alguns problemas com os csvs por causa dos ponto e virgula e depois também com a virgula.
	*/
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductSellingRestrictionsService productSellingRestrictionsService;
	
	@Autowired
	private TaxesUtils taxesUtils;
	
	@Autowired
	private ProductUtils productUtils;

	@Autowired
	private ClientUtils clientUtils;
	
	@PostMapping("/search")
	public ResponseEntity<?> search(@RequestHeader("clientId") Integer clientId, @RequestBody String name) {
		
		try {
			clientUtils.clientValidation(clientId);
			List<Product> products = productService.findProductsByNameLike(name);
			productUtils.productValidation(products);
			
			List<Map<String,Object>> productsMap = new ArrayList<Map<String,Object>>();
			for(Product product: products) {
				ProductSellingRestrictions productSellingRestrictions 
					= productSellingRestrictionsService.findByClientAndProduct(clientId, product.getProductId());
				if(productSellingRestrictions != null) {
					continue;
				}
				
				Double taxes = taxesUtils.calculateTotalTaxes(clientId,product.getPrice());
				productsMap.add(product.buildProductMap(taxes));
			}

			return new ResponseEntity<>(productsMap, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
