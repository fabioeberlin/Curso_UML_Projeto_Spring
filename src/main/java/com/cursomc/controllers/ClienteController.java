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

import com.cursomc.domain.Cliente;
import com.cursomc.dtos.ClienteDto;
import com.cursomc.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	final ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	public ResponseEntity<Cliente> saveCliente(@RequestBody @Valid ClienteDto clienteDto){
		var cliente = new Cliente();
		BeanUtils.copyProperties(clienteDto, cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getAllClientes(){
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
	}
	
	@GetMapping("/{cliente_id}")
	public ResponseEntity<Object> getOneCliente(@PathVariable(value = "cliente_id") Long id){
		Optional<Cliente> clienteOptional = clienteService.findById(id);
		if (!clienteOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CLiente não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());
	}
	
	@DeleteMapping("/{cliente_id}")
	public ResponseEntity<Object> deleteCliente(@PathVariable(value = "cliente_id") Long id){
		Optional<Cliente> clienteOptional = clienteService.findById(id);
		if (!clienteOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body("Cliente não encontrado");
		}
		clienteService.delete(clienteOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Cliente excluido com sucesso!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCliente (@PathVariable(value = "id") Long id, @RequestBody @Valid ClienteDto clienteDto){
		Optional<Cliente> clienteOptional = clienteService.findById(id);
		if (!clienteOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
		}
		
		var cliente = clienteOptional.get();
		cliente.setNome(clienteDto.getNome());
		cliente.setEmail(clienteDto.getEmail());
		cliente.setCpfOuCnpj(clienteDto.getCpfOuCnpj());
		cliente.setTipo(clienteDto.getTipo());
		
		
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(cliente));
	}

}
