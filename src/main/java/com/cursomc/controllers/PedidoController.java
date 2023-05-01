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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursomc.domain.Pedido;
import com.cursomc.dtos.PedidoDto;
import com.cursomc.services.PedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {
	
	final PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		super();
		this.pedidoService = pedidoService;
	}


	@PostMapping
	public ResponseEntity<Pedido> savePedido(@RequestBody @Valid PedidoDto pedidoDto){
		var pedido = new Pedido();
		BeanUtils.copyProperties(pedidoDto, pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedido));
	}
	
	@GetMapping
	public ResponseEntity<List<Pedido>> getAllPedidos(){
		return ResponseEntity.status(HttpStatus.OK).body(pedidoService.findAll());
	}
	
	@GetMapping("/{pedido_id}")
	public ResponseEntity<Object> getOnePedido(@PathVariable(value = "pedido_id") Long id){
		Optional<Pedido> pedidoOptional = pedidoService.findById(id);
		if (!pedidoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(pedidoOptional.get());
	}
	
	@DeleteMapping("/{pedido_id}")
	public ResponseEntity<Object> deletePedido(@PathVariable(value = "pedido_id") Long id){
		Optional<Pedido> pedidoOptional = pedidoService.findById(id);
		if (!pedidoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body("Pedido não encontrada");
		}
		pedidoService.delete(pedidoOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Pedido excluido com sucesso");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePedido (@PathVariable(value = "id") Long id, @RequestBody @Valid PedidoDto pedidoDto){
		Optional<Pedido> pedidoOptional = pedidoService.findById(id);
		if (!pedidoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrada");
		}
		
		var pedido = pedidoOptional.get();
		pedido.setInstante(pedidoDto.getInstante());
		
		return ResponseEntity.status(HttpStatus.OK).body(pedidoService.save(pedido));
	}
}
