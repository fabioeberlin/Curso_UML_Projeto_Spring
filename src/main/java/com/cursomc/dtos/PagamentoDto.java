package com.cursomc.dtos;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoDto {
	
	@NotBlank
	private Date dataVencimento;
	@NotBlank	
	private Date dataPagamento;
	@NotBlank
	private Long numeroParcelas;
}
