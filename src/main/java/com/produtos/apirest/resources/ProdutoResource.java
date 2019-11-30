package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping(value="/api")
public class ProdutoResource {

	 @Autowired
	 ProdutoRepository produtoRepository;
	 
	 
	 //LIST ALL PRODUCTS
	 @GetMapping("/produtos")
	 public List<Produto> listaProdutos(){ 
		return produtoRepository.findAll();
	 }
	
	//LIST ONE PRODUCT CRIAR METODO FINDBYID NO REPOSITORY
    @GetMapping("/produto/{id}")
	public Produto listaProdutoUnico(@PathVariable(value="id") long id){ 
	  return produtoRepository.findById(id);
	}
    
    /*
       SAVE PRODUCT ON POSTMAN CONTENT-TYPE application/json || NO NEED ID 
       JSON FORMAT:
       {
         "name": "bones",
         "quantidade": 10,
         "valor": 5
       }
     */
    @PostMapping("/produto")
    public Produto salvaProduto(@RequestBody Produto produto) {
      return produtoRepository.save(produto);
    }
    
    /*
 	DELETE PRODUCT ON POSTMAN CONTENT-TYPE application/json || NO NEED ID 
 	ALTERAR POST PARA DELETE
    JSON FORMAT:
    {
      "id": 1
      "name": "bones",
      "quantidade": 10,
      "valor": 5
    }
  */
    @DeleteMapping("/produto")
    public void deletaProduto(@RequestBody Produto produto) {
      produtoRepository.delete(produto);
    }
    
    
    /*
 	DELETE PRODUCT ON POSTMAN CONTENT-TYPE application/json || NO NEED ID 
 	ALTERAR POST PARA PUT
    JSON FORMAT:
    {
      "id": 1
      "name": "bones",
      "quantidade": 10,
      "valor": 5
    }
    */
    @PutMapping("/produto")
    public Produto atualizaProduto(@RequestBody Produto produto) {
      return produtoRepository.save(produto);
    }
}
