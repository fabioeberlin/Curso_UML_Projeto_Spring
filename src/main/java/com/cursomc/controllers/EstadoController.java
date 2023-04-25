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

import com.cursomc.domain.Estado;
import com.cursomc.dtos.EstadoDto;
import com.cursomc.services.EstadoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {
	
	final EstadoService estadoService;

	public EstadoController(EstadoService estadoService) {
		this.estadoService = estadoService;
	}

	@PostMapping
	public ResponseEntity<Estado> saveEstado(@RequestBody @Valid EstadoDto estadoDto){
		var estado = new Estado();
		BeanUtils.copyProperties(estadoDto, estado);
		return ResponseEntity.status(HttpStatus.CREATED).body(estadoService.save(estado));
	}
	
	@GetMapping
	public ResponseEntity<List<Estado>> getAllEstados(){
		return ResponseEntity.status(HttpStatus.OK).body(estadoService.findAll());
	}
	
	@GetMapping("/{estado_id}")
	public ResponseEntity<Object> getOneEstado(@PathVariable(value = "estado_id") Long id){
		Optional<Estado> estadoOptional = estadoService.findById(id);
		if (!estadoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estado não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(estadoOptional.get());
	}
	
	@DeleteMapping("/{estado_id}")
	public ResponseEntity<Object> deleteEstado(@PathVariable(value = "estado_id") Long id){
		Optional<Estado> estadoOptional = estadoService.findById(id);
		if (!estadoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body("Estado não encontrado");
		}
		estadoService.delete(estadoOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Estado deletado com sucesso");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEstado (@PathVariable(value = "id") Long id, @RequestBody @Valid EstadoDto estadoDto){
		Optional<Estado> estadoOptional = estadoService.findById(id);
		if (!estadoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estado não encontrado");
		}
		
		var estado = estadoOptional.get();
		estado.setNome(estadoDto.getNome());
		
		return ResponseEntity.status(HttpStatus.OK).body(estadoService.save(estado));
	}

}
