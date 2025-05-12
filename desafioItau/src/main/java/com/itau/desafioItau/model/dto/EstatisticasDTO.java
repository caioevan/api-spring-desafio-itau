package com.itau.desafioItau.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EstatisticasDTO {
	
	private double soma;
    private double media;
    private double maximo;
    private double minimo;
    private long contagem;
    
}
