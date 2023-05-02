package com.cursomc.domain;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Embeddable
@Data
@EqualsAndHashCode
@Table(name = "tb_item_pedido_pk")
public class ItemPedidoPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Pedido pedido;
	
	@ManyToOne
	private Produto produto;

}
