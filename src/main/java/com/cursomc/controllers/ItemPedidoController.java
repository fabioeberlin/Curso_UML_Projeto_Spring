package com.cursomc.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursomc.domain.ItemPedido;
import com.cursomc.dtos.ItemPedidoDto;
import com.cursomc.services.ItemPedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/itempedidos")
public class ItemPedidoController {
	
	final ItemPedidoService itemPedidoService;

	public ItemPedidoController(ItemPedidoService itemPedidoService) {
		super();
		this.itemPedidoService = itemPedidoService;
	}

	@PostMapping
	public ResponseEntity<ItemPedido> saveItemPedido(@RequestBody @Valid ItemPedidoDto itemPedidoDto){
		var itemPedido = new ItemPedido();
		BeanUtils.copyProperties(itemPedidoDto, itemPedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemPedidoService.save(itemPedido));
	}
	
	@GetMapping
	public ResponseEntity<List<ItemPedido>> getAllItensPedidos(){
		return ResponseEntity.status(HttpStatus.OK).body(itemPedidoService.findAll());
	}
	

	
}
