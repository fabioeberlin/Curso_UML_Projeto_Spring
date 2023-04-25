package com.cursomc.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {
	
	@NotBlank
	private String nome;
	
	//@NotBlank
	private BigDecimal preco;

}
