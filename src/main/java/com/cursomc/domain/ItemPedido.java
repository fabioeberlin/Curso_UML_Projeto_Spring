package com.cursomc.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tb_item_pedido")
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	@JsonIgnore
	private ItemPedidoPk id = new ItemPedidoPk();
	
	private Double desconto;
	@Column(nullable = false)
	private Integer quantidade;
	@Column(nullable = false)
	private Double preco;

}
