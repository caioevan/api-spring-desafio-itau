package com.itau.desafioItau.model.repositories;


import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.itau.desafioItau.model.entities.Transaction;

@Repository
public class TransactionRepository {

	private static TransactionRepository instancia = new TransactionRepository();
	
	private List<Transaction> transacoes = new ArrayList<>();

	private static final AtomicLong idGenerator = new AtomicLong(1);
	
	private TransactionRepository () {}
	
	public static TransactionRepository getInstancia () {
		
		if(instancia == null) {
			instancia = new TransactionRepository();
		}
		return instancia;
	}
	
	public List<Transaction> mostrarTransacoes() {
		return transacoes;
	}
	
	public Transaction adicionarTransacao(BigDecimal valor, OffsetDateTime dataHora) {
		long id  = idGenerator.getAndIncrement();
		Transaction transacao = new Transaction(id, valor, dataHora);
		transacoes.add(transacao);
		
		return transacao;
	}
	
	public void limparTransacoes(List<Transaction> transacoes) {
		transacoes.clear();
	}
	
}
