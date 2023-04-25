package com.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cursomc.domain.Cidade;
import com.cursomc.repositories.CidadeRepository;

import jakarta.transaction.Transactional;

@Service
public class CidadeService {
	
	final CidadeRepository cidadeRepository;

	public CidadeService(CidadeRepository cidadeRepository) {
		this.cidadeRepository = cidadeRepository;
	}

	@Transactional
	public Cidade save(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

	@Transactional
	public List<Cidade> findAll() {
		return cidadeRepository.findAll();
	}
	
	public Optional<Cidade> findById(Long id) {
		return cidadeRepository.findById(id);
	}

	@Transactional
	public void delete(Cidade cidade) {
		cidadeRepository.delete(cidade);
	}
	
}
