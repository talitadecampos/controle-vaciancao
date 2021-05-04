package br.com.aplicacaovacinas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aplicacaovacinas.dto.CadastroUsuarioDTO;
import br.com.aplicacaovacinas.entidades.Usuario;
import br.com.aplicacaovacinas.repositorio.UsuarioRepository;
@Service 
public class UsuarioService {
	@Autowired
	UsuarioRepository repositorio;
	
	public Usuario criarUsuarioDoDTO(CadastroUsuarioDTO usuarioDTO, Usuario... usuario) {
		Usuario usuarioNovo;
		
		if(usuario.length == 0 || null == usuario[0]) usuarioNovo = new Usuario();
		else usuarioNovo = usuario[0];
		
		usuarioNovo.setCpf(usuarioDTO.getCpf());
		usuarioNovo.setDataNascto(usuarioDTO.getDataNascto());
		usuarioNovo.setEmail(usuarioDTO.getEmail());
		usuarioNovo.setNome(usuarioDTO.getNome());
		return usuarioNovo;
		
	}
	
	public Usuario salvarUsuario(CadastroUsuarioDTO usuarioDTO) {
		Usuario usuarioAtual = this.criarUsuarioDoDTO(usuarioDTO);
		return repositorio.save(usuarioAtual);
	}
	
	public Usuario alterarUsuario(CadastroUsuarioDTO usuarioDTO) {
		Usuario usuarioAtual = repositorio.getByCpf(usuarioDTO.getCpf());

		usuarioAtual = this.criarUsuarioDoDTO(usuarioDTO, usuarioAtual);
		return repositorio.save(usuarioAtual);
	}
}
