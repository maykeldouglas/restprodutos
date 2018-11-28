package com.produtos.restprodutos.resources;


import com.produtos.restprodutos.models.Produto;
import com.produtos.restprodutos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produtos/{id}")
    public Produto listaProdutos(@PathVariable(value = "id") long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("/produto")
    public Produto insereProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produto")
    public void deletaProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }

    @PutMapping("/produto")
    public Produto alteraProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

}
