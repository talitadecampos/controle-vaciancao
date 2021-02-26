package br.com.aplicacaovacinas.controller;

import br.com.aplicacaovacinas.repositorio.UsuarioRepository;
import br.com.aplicacaovacinas.dto.AplicacaoVacinaDTO;
import br.com.aplicacaovacinas.entidades.AplicacaoVacina;
import br.com.aplicacaovacinas.entidades.Usuario;
import br.com.aplicacaovacinas.repositorio.AplicacaoVacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class AplicacaoVacinaController {

  @Autowired
  private UsuarioRepository repositorioUsuario;

  @Autowired
  private AplicacaoVacinaRepository repositorioAplicacaoVacina;

  @PostMapping("/aplicacaoVacina")
  public ResponseEntity<AplicacaoVacinaDTO> aplicarVacina(@RequestBody @Valid AplicacaoVacinaDTO vacinaAplicada, UriComponentsBuilder uriBuilder) {
    AplicacaoVacina aplicacaoVacina = new AplicacaoVacina();
    aplicacaoVacina.setDataAplicacao(vacinaAplicada.getDataAplicacao());
    aplicacaoVacina.setNomeVacina(vacinaAplicada.getNomeVacina());

    Usuario usuarioVacinado = repositorioUsuario.getByEmail(vacinaAplicada.getEmail());

    aplicacaoVacina.setUsuario(usuarioVacinado);
    repositorioAplicacaoVacina.save(aplicacaoVacina);

    vacinaAplicada.setCPF(usuarioVacinado.getCpf());
    vacinaAplicada.setNomeUsuario(usuarioVacinado.getNome());

    URI uri = uriBuilder.path("/aplicacaoVacina/{id}").buildAndExpand(aplicacaoVacina.getIdVacinacao()).toUri();
    return ResponseEntity.created(uri).body(vacinaAplicada);
  }
}
