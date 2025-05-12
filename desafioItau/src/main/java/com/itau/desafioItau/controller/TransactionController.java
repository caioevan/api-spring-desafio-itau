package com.itau.desafioItau.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.desafioItau.model.dto.EstatisticasDTO;
import com.itau.desafioItau.model.dto.TransactionDTO;
import com.itau.desafioItau.model.entities.Transaction;
import com.itau.desafioItau.model.service.TransactionService;

@RestController
@RequestMapping("/itau")
public class TransactionController {

	@Autowired
	TransactionService service;
	
	@PostMapping("/transacao")
	public ResponseEntity<TransactionDTO> addTransacao(@RequestBody TransactionDTO dto) {
		TransactionDTO resultado = service.adicionarTransacao(dto.getValor(), dto.getDataHora());
		return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
	}
	
	@DeleteMapping("/transacao")
	public ResponseEntity<List<Transaction>> deletarTransacoes (){
		List<Transaction> transacoes = service.getTransacoes();
		service.deletarTransacoes(transacoes);
		return ResponseEntity.status(HttpStatus.OK).body(transacoes);
	}
	
	@GetMapping("/estatisticas")
	public ResponseEntity<EstatisticasDTO> getEstatisticas() {
		EstatisticasDTO estatisticas = service.getEstatisticas();
		return ResponseEntity.status(HttpStatus.OK).body(estatisticas);
	}
	
	@GetMapping("/transacao")
	public ResponseEntity<List<Transaction>> getTransacoes() {
		List<Transaction> transacoes = service.getTransacoes();
		return ResponseEntity.status(HttpStatus.OK).body(transacoes);
	}
	
	
}
