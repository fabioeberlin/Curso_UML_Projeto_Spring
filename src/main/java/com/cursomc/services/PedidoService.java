package com.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cursomc.domain.Pedido;
import com.cursomc.repositories.PedidoRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {
	
	final PedidoRepository pedidoRepository;

	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	@Transactional
	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@Transactional
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}
	
	public Optional<Pedido> findById(Long id) {
		return pedidoRepository.findById(id);
	}

	@Transactional
	public void delete(Pedido pedido) {
		pedidoRepository.delete(pedido);
	}
	
}
