package com.challenge.productAPI.model;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProductSellingRestrictions {
	
	private Integer idCliente; 
	private Integer idProduto;
	
	public ProductSellingRestrictions() {}

	public ProductSellingRestrictions(Integer idCliente, Integer idProduto) {
		super();
		this.idCliente = idCliente;
		this.idProduto = idProduto;
	}

	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
}
