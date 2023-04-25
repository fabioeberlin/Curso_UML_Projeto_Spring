package com.cursomc.services;

import org.springframework.stereotype.Service;

import com.cursomc.domain.Categoria;
import com.cursomc.repositories.CategoriaRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoriaService {
	
	final CategoriaRepository categoriaRepository;

	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@Transactional
	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
}
