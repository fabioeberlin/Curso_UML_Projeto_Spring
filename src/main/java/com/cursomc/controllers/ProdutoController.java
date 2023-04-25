package com.cursomc.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursomc.domain.Categoria;
import com.cursomc.domain.Produto;
import com.cursomc.dtos.CategoriaDto;
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
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAllProdutos(){
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
	}
	
	@GetMapping("/{produto_id}")
	public ResponseEntity<Object> getOneProduto(@PathVariable(value = "produto_id") Long id){
		Optional<Produto> produtoOptional = produtoService.findById(id);
		if (!produtoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrada");
		}
		return ResponseEntity.status(HttpStatus.OK).body(produtoOptional.get());
	}
	
	@DeleteMapping("/{produto_id}")
	public ResponseEntity<Object> deleteProduto(@PathVariable(value = "produto_id") Long id){
		Optional<Produto> produtoOptional = produtoService.findById(id);
		if (!produtoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body("Produto não encontrada");
		}
		produtoService.delete(produtoOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProduto (@PathVariable(value = "id") Long id, @RequestBody @Valid ProdutoDto produtoDto){
		Optional<Produto> produtoOptional = produtoService.findById(id);
		if (!produtoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrada");
		}
		
		var produto = produtoOptional.get();
		produto.setNome(produtoDto.getNome());
		produto.setPreco(produtoDto.getPreco());
		
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produto));
	}

}
