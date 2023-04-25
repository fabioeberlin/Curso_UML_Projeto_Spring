package com.cursomc.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursomc.domain.Produto;
import com.cursomc.dtos.ProdutoDto;
import com.cursomc.services.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	
	final ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		super();
		this.produtoService = produtoService;
	}


	@PostMapping
	public ResponseEntity<Produto> saveProduto(@RequestBody @Valid ProdutoDto produtoDto){
		var produto = new Produto();
		BeanUtils.copyProperties(produtoDto, produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
	}

}
