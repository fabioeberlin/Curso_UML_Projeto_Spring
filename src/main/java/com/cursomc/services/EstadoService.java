package com.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cursomc.domain.Estado;
import com.cursomc.repositories.EstadoRepository;

import jakarta.transaction.Transactional;

@Service
public class EstadoService {
	
	final EstadoRepository estadoRepository;

	public EstadoService(EstadoRepository estadoRepository) {
		this.estadoRepository = estadoRepository;
	}

	@Transactional
	public Estado save(Estado estado) {
		return estadoRepository.save(estado);
	}

	@Transactional
	public List<Estado> findAll() {
		return estadoRepository.findAll();
	}
	
	public Optional<Estado> findById(Long id) {
		return estadoRepository.findById(id);
	}

	@Transactional
	public void delete(Estado estado) {
		estadoRepository.delete(estado);
	}
	
}
