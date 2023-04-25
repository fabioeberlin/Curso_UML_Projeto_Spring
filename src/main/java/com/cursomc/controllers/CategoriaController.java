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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursomc.domain.Categoria;
import com.cursomc.dtos.CategoriaDto;
import com.cursomc.services.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	final CategoriaService categoriaService;

	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	@PostMapping
	public ResponseEntity<Categoria> saveCategoria(@RequestBody @Valid CategoriaDto categoriaDto){
		var categoria = new Categoria();
		BeanUtils.copyProperties(categoriaDto, categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
	}
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAllCategorias(){
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findAll());
	}
	
	@GetMapping("/{categoria_id}")
	public ResponseEntity<Object> getOneProduto(@PathVariable(value = "categoria_id") Long id){
		Optional<Categoria> categoriaOptional = categoriaService.findById(id);
		if (!categoriaOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada");
		}
		return ResponseEntity.status(HttpStatus.OK).body(categoriaOptional.get());
	}
	
	@DeleteMapping("/{categoria_id}")
	public ResponseEntity<Object> deleteCategoria(@PathVariable(value = "categoria_id") Long id){
		Optional<Categoria> categoriaOptional = categoriaService.findById(id);
		if (!categoriaOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body("Categoria não encontrada");
		}
		categoriaService.delete(categoriaOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Categoria deletada com sucesso");
	}

}
