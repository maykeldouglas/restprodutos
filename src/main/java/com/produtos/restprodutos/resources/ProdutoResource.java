package com.produtos.restprodutos.resources;


import com.produtos.restprodutos.models.Produto;
import com.produtos.restprodutos.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    @ApiOperation(value = "Retorna uma lista de produtos.")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produtos/{id}")
    @ApiOperation(value = "Retorna um produto específico por ID.")
    public Produto listaProdutos(@PathVariable(value = "id") long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("/produto")
    @ApiOperation(value = "Insere um produto.")
    public Produto insereProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produto")
    @ApiOperation(value = "Exclui um produto.")
    public void deletaProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }

    @PutMapping("/produto")
    @ApiOperation(value = "Atualiza um produto.")
    public Produto alteraProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

}