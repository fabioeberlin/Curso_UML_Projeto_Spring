package com.cursomc.dtos;

import com.cursomc.domain.Estado;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeDto {
	
	@NotBlank
	private String nome;
	@NotBlank
	private Estado estado;
	
}
