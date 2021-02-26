package br.com.aplicacaovacinas.controller;

import br.com.aplicacaovacinas.repositorio.UsuarioRepository;
import br.com.aplicacaovacinas.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
public class UsuarioController {

  @Autowired
  UsuarioRepository repositorio;

  @PostMapping("/usuarios")
  public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody @Valid Usuario novoUsuario, UriComponentsBuilder uriBuilder) {
    repositorio.save(novoUsuario);

    URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(novoUsuario.getId()).toUri();

    return ResponseEntity.created(uri).body(novoUsuario);
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
}
