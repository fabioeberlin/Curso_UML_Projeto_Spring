package com.cursomc.services;

import org.springframework.stereotype.Service;

import com.cursomc.domain.Produto;
import com.cursomc.repositories.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
	
	final ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@Transactional
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}
	
}
