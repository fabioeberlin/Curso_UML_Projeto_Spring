package com.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cursomc.domain.Endereco;
import com.cursomc.repositories.EnderecoRepository;

import jakarta.transaction.Transactional;

@Service
public class EnderecoService {
	
	final EnderecoRepository enderecoRepository;

	public EnderecoService(EnderecoRepository enderecoRepository) {
		super();
		this.enderecoRepository = enderecoRepository;
	}

	@Transactional
	public Endereco save(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	@Transactional
	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}
	
	public Optional<Endereco> findById(Long id) {
		return enderecoRepository.findById(id);
	}

	@Transactional
	public void delete(Endereco endereco) {
		enderecoRepository.delete(endereco);
	}
	
}
