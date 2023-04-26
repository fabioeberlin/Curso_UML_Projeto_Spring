package com.cursomc.dtos;

import com.cursomc.enums.TipoCliente;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	@NotBlank
	private String cpfOuCnpj;
	
	private TipoCliente tipo;
	
	
}
