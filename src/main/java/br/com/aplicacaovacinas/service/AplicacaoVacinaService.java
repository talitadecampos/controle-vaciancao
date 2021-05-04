package br.com.aplicacaovacinas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aplicacaovacinas.dto.AplicacaoVacinaDTO;
import br.com.aplicacaovacinas.entidades.AplicacaoVacina;
import br.com.aplicacaovacinas.entidades.Usuario;
import br.com.aplicacaovacinas.repositorio.AplicacaoVacinaRepository;
import br.com.aplicacaovacinas.repositorio.UsuarioRepository;

@Service
public class AplicacaoVacinaService {
	@Autowired
	private UsuarioRepository repositorioUsuario;

	@Autowired
	private AplicacaoVacinaRepository repositorioAplicacaoVacina;
	
	public AplicacaoVacina salvarAplicacaoVacina(AplicacaoVacinaDTO vacinaAplicada) {
		AplicacaoVacina aplicacaoVacina = new AplicacaoVacina();
		aplicacaoVacina.setDataAplicacao(vacinaAplicada.getDataAplicacao());
		aplicacaoVacina.setNomeVacina(vacinaAplicada.getNomeVacina());

		Usuario usuarioVacinado = repositorioUsuario.getByEmail(vacinaAplicada.getEmail());

		aplicacaoVacina.setUsuario(usuarioVacinado);
		repositorioAplicacaoVacina.save(aplicacaoVacina);
		
		return aplicacaoVacina;
		
	}
}
