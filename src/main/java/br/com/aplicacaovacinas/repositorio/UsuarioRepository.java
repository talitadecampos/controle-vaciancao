package br.com.aplicacaovacinas.repositorio;

import br.com.aplicacaovacinas.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  public Usuario getByEmail(String emailDoUsuario);
  
  public Usuario getByCpf(String cpf);
}
