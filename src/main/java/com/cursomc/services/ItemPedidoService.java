package com.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cursomc.domain.ItemPedido;
import com.cursomc.repositories.ItemPedidoRepository;

import jakarta.transaction.Transactional;

@Service
public class ItemPedidoService {
	
	final ItemPedidoRepository itemPedidoRepository;

	public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
		super();
		this.itemPedidoRepository = itemPedidoRepository;
	}

	@Transactional
	public ItemPedido save(ItemPedido itemPedido) {
		return itemPedidoRepository.save(itemPedido);
	}

	@Transactional
	public List<ItemPedido> findAll() {
		return itemPedidoRepository.findAll();
	}
	
	public Optional<ItemPedido> findById(Long id) {
		return itemPedidoRepository.findById(id);
	}

	@Transactional
	public void delete(ItemPedido itemPedido) {
		itemPedidoRepository.delete(itemPedido);
	}
	
}
