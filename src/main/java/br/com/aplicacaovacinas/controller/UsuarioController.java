package br.com.aplicacaovacinas.controller;

import br.com.aplicacaovacinas.repositorio.UsuarioRepository;
import br.com.aplicacaovacinas.dto.CadastroUsuarioDTO;
import br.com.aplicacaovacinas.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
public class UsuarioController {

  @Autowired
  UsuarioRepository repositorio;

  @PostMapping("/usuarios")
  public ResponseEntity<CadastroUsuarioDTO> cadastrarUsuario(@RequestBody @Valid Usuario novoUsuario, UriComponentsBuilder uriBuilder) {
    repositorio.save(novoUsuario);

    URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(novoUsuario.getId()).toUri();

    CadastroUsuarioDTO usuarioNovoCadastro = new CadastroUsuarioDTO();
    usuarioNovoCadastro.setCpf(novoUsuario.getCpf());
    usuarioNovoCadastro.setDataNascto(novoUsuario.getDataNascto());
    usuarioNovoCadastro.setEmail(novoUsuario.getEmail());
    usuarioNovoCadastro.setNome(novoUsuario.getNome());
  
    
    return ResponseEntity.created(uri).body(usuarioNovoCadastro);
  }

  @PutMapping("/usuarios/{idUsuario}")
  public ResponseEntity<Usuario> alterarUsuario(@PathVariable(value="idUsuario") Long idUsuario, @RequestBody @Valid Usuario usuarioAlterado, UriComponentsBuilder uriBuilder) {
    Usuario usuarioAtual = repositorio.getOne(idUsuario);

    usuarioAtual.setCpf(usuarioAlterado.getCpf());
    usuarioAtual.setDataNascto(usuarioAlterado.getDataNascto());
    usuarioAtual.setEmail(usuarioAlterado.getEmail());
    usuarioAtual.setNome(usuarioAlterado.getNome());

    usuarioAlterado = repositorio.save(usuarioAtual);

    return ResponseEntity.ok(usuarioAlterado);
  }
  
  @ExceptionHandler(DataIntegrityViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<String> tratarErroCadastro(DataIntegrityViolationException exception) {
	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados Inválidos: " + exception.getMessage());
	  
  }
  
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<String> tratarCampoVazio(MethodArgumentNotValidException exception) {
	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados Inválidos: " + exception.getMessage());
  }

}

