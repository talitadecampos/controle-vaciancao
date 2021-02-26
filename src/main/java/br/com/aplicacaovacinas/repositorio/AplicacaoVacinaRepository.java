package br.com.aplicacaovacinas.repositorio;

import br.com.aplicacaovacinas.entidades.AplicacaoVacina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AplicacaoVacinaRepository extends JpaRepository<AplicacaoVacina, Long> {
}
