package com.cursomc.domain;

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
@Table(name = "tb_pagamento_cartao")
public class PagamentoComCartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private Integer numeroDeParcelas; 

}
