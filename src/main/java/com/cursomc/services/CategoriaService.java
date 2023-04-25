package com.cursomc.services;

import java.util.List;
import java.util.Optional;

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

	@Transactional
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
	
	public Optional<Categoria> findById(Long id) {
		return categoriaRepository.findById(id);
	}

	@Transactional
	public void delete(Categoria categoria) {
		categoriaRepository.delete(categoria);
	}
	
}
