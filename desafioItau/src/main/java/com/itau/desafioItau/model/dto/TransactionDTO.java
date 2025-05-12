package com.itau.desafioItau.model.dto;

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
public class TransactionDTO {

	private Long id;
	private BigDecimal valor;
	private OffsetDateTime dataHora;
	
}
