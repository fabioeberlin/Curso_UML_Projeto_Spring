package com.cursomc.domain;

import java.io.Serializable;

import com.cursomc.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	@JsonBackReference
	private Pedido pedido;

}
