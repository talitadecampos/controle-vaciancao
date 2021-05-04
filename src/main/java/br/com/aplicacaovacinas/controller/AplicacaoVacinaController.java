package br.com.aplicacaovacinas.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.aplicacaovacinas.dto.AplicacaoVacinaDTO;
import br.com.aplicacaovacinas.entidades.AplicacaoVacina;
import br.com.aplicacaovacinas.service.AplicacaoVacinaService;

@RestController
public class AplicacaoVacinaController {

	@Autowired
	AplicacaoVacinaService service;

	@PostMapping("/aplicacaoVacina")
	public ResponseEntity<AplicacaoVacinaDTO> aplicarVacina(@RequestBody @Valid AplicacaoVacinaDTO vacinaAplicada,
			UriComponentsBuilder uriBuilder) {
		
		
		AplicacaoVacina vacinaSalva = service.salvarAplicacaoVacina(vacinaAplicada);
		vacinaAplicada.setCPF(vacinaSalva.getUsuario().getCpf());
		vacinaAplicada.setNomeUsuario(vacinaSalva.getUsuario().getNome());

		URI uri = uriBuilder.path("/aplicacaoVacina/{id}").buildAndExpand(vacinaSalva.getIdVacinacao()).toUri();
		return ResponseEntity.created(uri).body(vacinaAplicada);
	}


	
}
