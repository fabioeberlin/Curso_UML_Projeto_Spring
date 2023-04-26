package com.cursomc.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Setter
@Getter
@Table(name = "tb_pagamento_boleto")
public class PagamentoComBoleto extends Pagamento {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private Date dataVencimento;
	
	@Column(nullable = false)
	private Date dataPagamento;
}
