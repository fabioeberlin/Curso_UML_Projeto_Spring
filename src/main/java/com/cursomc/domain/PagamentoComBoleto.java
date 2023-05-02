package com.cursomc.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_pagamento_boleto")
public class PagamentoComBoleto extends Pagamento {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataVencimento;
	
	@Column(nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataPagamento;
}
