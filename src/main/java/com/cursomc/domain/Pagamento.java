package com.cursomc.domain;

import java.io.Serializable;

import com.cursomc.enums.EstadoPagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_pagamento")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pagamento implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	private Long id;
	
	private EstadoPagamento estado;
	
	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId
	private Pedido pedido;

}
