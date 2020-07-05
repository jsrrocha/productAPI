package com.challenge.productAPI.model;
import org.springframework.data.mongodb.core.mapping.Document;

/*
* A estratégia para todas as coleções foi deixar igual a estrutura da especificaçção
* Porém, quando eu importei os .csvs pelo mongoimport foi criado pra cada um o campo _id 
* com valor tipo assim: ObjectId("5f00cd21e5fd12568e594348")
* Fiquei meio confusa com isso, mas deixei sem o @id minhas coleções e funcionou, 
* não sei se pode ocorrer algum problema no banco de vocês ai.
*/

@Document
public class Client {
	
	private Integer idCliente; 
	private String CNPJ;
	private String Nome;
	
	public Client() {}
	
	public Client(Integer idCliente, String CNPJ, String nome) {
		super();
		this.idCliente = idCliente;
		this.CNPJ = CNPJ;
		Nome = nome;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
}
