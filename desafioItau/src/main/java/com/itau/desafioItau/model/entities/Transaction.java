package com.itau.desafioItau.model.entities;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {

	private Long id;
	private BigDecimal valor;
	private OffsetDateTime dataHora;
	
	public Transaction (BigDecimal valor, OffsetDateTime dataHora) {
		this.valor = valor;
		this.dataHora = dataHora;
	}
	
}
