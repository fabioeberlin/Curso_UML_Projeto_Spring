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

import com.cursomc.domain.Cidade;
import com.cursomc.dtos.CidadeDto;
import com.cursomc.services.CidadeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {
	
	final CidadeService cidadeService;

	public CidadeController(CidadeService cidadeService) {
		this.cidadeService = cidadeService;
	}

	@PostMapping
	public ResponseEntity<Cidade> saveCidade(@RequestBody @Valid CidadeDto cidadeDto){
		var cidade = new Cidade();
		BeanUtils.copyProperties(cidadeDto, cidade);
		return ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.save(cidade));
	}
	
	@GetMapping
	public ResponseEntity<List<Cidade>> getAllCidades(){
		return ResponseEntity.status(HttpStatus.OK).body(cidadeService.findAll());
	}
	
	@GetMapping("/{cidade_id}")
	public ResponseEntity<Object> getOneCidade(@PathVariable(value = "cidade_id") Long id){
		Optional<Cidade> cidadeOptional = cidadeService.findById(id);
		if (!cidadeOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cidade não encontrada");
		}
		return ResponseEntity.status(HttpStatus.OK).body(cidadeOptional.get());
	}
	
	@DeleteMapping("/{cidade_id}")
	public ResponseEntity<Object> deleteCidade(@PathVariable(value = "cidade_id") Long id){
		Optional<Cidade> cidadeOptional = cidadeService.findById(id);
		if (!cidadeOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body("Cidade não encontrada");
		}
		cidadeService.delete(cidadeOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Cidade excluida com sucesso!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCidade (@PathVariable(value = "id") Long id, @RequestBody @Valid CidadeDto cidadeDto){
		Optional<Cidade> cidadeOptional = cidadeService.findById(id);
		if (!cidadeOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cidade não encontrada");
		}
		
		var cidade = cidadeOptional.get();
		cidade.setNome(cidadeDto.getNome());
		
		return ResponseEntity.status(HttpStatus.OK).body(cidadeService.save(cidade));
	}

}
