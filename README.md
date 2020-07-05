# API de produto

Buscar os produtos que contenha uma string passada pelo body considerando o id do cliente no HEADER para filtrar os produtos com restrição de vendas e também para buscar as alíquotas de impostos. 
O retorno é uma lista de produtos no formato: [{ productId : Integer, name : String, price : Double, taxes : Double }] 
