package com.produtos.apiprodutos.repository;

import com.produtos.apiprodutos.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto findById(long id);

}
