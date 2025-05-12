package com.itau.desafioItau.model.service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itau.desafioItau.model.dto.EstatisticasDTO;
import com.itau.desafioItau.model.dto.TransactionDTO;
import com.itau.desafioItau.model.entities.Transaction;
import com.itau.desafioItau.model.repositories.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository repo;
	
	public TransactionDTO adicionarTransacao (BigDecimal valor, OffsetDateTime dataHora) {
		if (valor == null || dataHora == null) {
	        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
	    }

	    if (dataHora.isAfter(OffsetDateTime.now())) {
	    	throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
	    }

	    if (valor.compareTo(BigDecimal.ZERO) < 0) {
	    	throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
	    }
	    
		Transaction transacao = repo.adicionarTransacao(valor, dataHora);
		TransactionDTO dto = new TransactionDTO(transacao.getId(), transacao.getValor(), transacao.getDataHora());
		return dto;
		
	}
	
	public List<Transaction> getTransacoes () {
		return repo.mostrarTransacoes();
	}
	
	public EstatisticasDTO getEstatisticas() {
	    DoubleSummaryStatistics stats = new DoubleSummaryStatistics();

	    for (Transaction t : repo.mostrarTransacoes()) {
	        if (t.getDataHora().isAfter(OffsetDateTime.now().minusSeconds(60))) {
	            stats.accept(t.getValor().doubleValue());
	        }
	    }
	    return new EstatisticasDTO(stats.getSum(), stats.getAverage(), stats.getMax(), stats.getMin(), stats.getCount());
	}
	
	public void deletarTransacoes(List<Transaction> transacoes) {
		repo.limparTransacoes(transacoes);
		}
}
