package com.cursomc.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoDto {
	
	@NotBlank
	private String nome;

}
