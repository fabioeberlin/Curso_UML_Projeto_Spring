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

import com.cursomc.domain.Endereco;
import com.cursomc.dtos.EnderecoDto;
import com.cursomc.services.EnderecoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {
	
	final EnderecoService enderecoService;

	public EnderecoController(EnderecoService enderecoService) {
		super();
		this.enderecoService = enderecoService;
	}

	@PostMapping
	public ResponseEntity<Endereco> saveEndereco(@RequestBody @Valid EnderecoDto enderecoDto){
		var endereco = new Endereco();
		BeanUtils.copyProperties(enderecoDto, endereco);
		return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(endereco));
	}
	
	@GetMapping
	public ResponseEntity<List<Endereco>> getAllEnderecos(){
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findAll());
	}
	
	@GetMapping("/{endereco_id}")
	public ResponseEntity<Object> getOneEndereco(@PathVariable(value = "endereco_id") Long id){
		Optional<Endereco> enderecoOptional = enderecoService.findById(id);
		if (!enderecoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(enderecoOptional.get());
	}
	
	@DeleteMapping("/{endereco_id}")
	public ResponseEntity<Object> deleteEndereco(@PathVariable(value = "endereco_id") Long id){
		Optional<Endereco> enderecoOptional = enderecoService.findById(id);
		if (!enderecoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body("Endereco não encontrado");
		}
		enderecoService.delete(enderecoOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Endereco excluido com sucesso!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEndereco (@PathVariable(value = "id") Long id, @RequestBody @Valid EnderecoDto enderecoDto){
		Optional<Endereco> enderecoOptional = enderecoService.findById(id);
		if (!enderecoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco não encontrado");
		}
		
		var endereco = enderecoOptional.get();
		endereco.setLogradouro(enderecoDto.getLogradouro());
		endereco.setNumero(enderecoDto.getNumero());
		endereco.setComplemento(enderecoDto.getComplemento());
		endereco.setBairro(enderecoDto.getBairro());
		endereco.setCep(enderecoDto.getCep());
		
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.save(endereco));
	}

}
