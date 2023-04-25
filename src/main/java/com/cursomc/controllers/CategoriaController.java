package com.cursomc.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
