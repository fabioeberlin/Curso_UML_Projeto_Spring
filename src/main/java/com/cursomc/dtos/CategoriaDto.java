package com.cursomc.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class CategoriaDto {
	
	@NotBlank
	@Getter
	@Setter
	private String nome;

}
