# API de produto

Chamada do serviço de busca: http://localhost:8080/api/product/search

Buscar os produtos que contenham uma string passada no body considerando o id do cliente no header para filtrar os produtos com restrição de vendas e também para buscar as alíquotas de impostos. <br />
O retorno é uma lista de produtos no formato: <br />
[{ <br />
  productId : Integer, name : String, price : Double, taxes : Double
<br />}]

