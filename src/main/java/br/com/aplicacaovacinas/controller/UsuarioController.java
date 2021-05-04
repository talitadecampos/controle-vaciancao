package br.com.aplicacaovacinas.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.aplicacaovacinas.dto.CadastroUsuarioDTO;
import br.com.aplicacaovacinas.entidades.Usuario;
import br.com.aplicacaovacinas.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService servico;

	@PostMapping("/usuarios")
	public ResponseEntity<CadastroUsuarioDTO> cadastrarUsuario(@RequestBody @Valid CadastroUsuarioDTO novoUsuario,
			UriComponentsBuilder uriBuilder) {

		Usuario usuario = servico.salvarUsuario(novoUsuario);
		

		URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();

		
		return ResponseEntity.created(uri).body(novoUsuario);
	}

	@PutMapping("/usuarios")
	public ResponseEntity<CadastroUsuarioDTO> alterarUsuario(@RequestBody @Valid CadastroUsuarioDTO usuarioAlterado, UriComponentsBuilder uriBuilder) {
		servico.alterarUsuario(usuarioAlterado);
		
		return ResponseEntity.ok(usuarioAlterado);
	}

	

}
