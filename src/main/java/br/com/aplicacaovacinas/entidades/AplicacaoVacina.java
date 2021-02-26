package br.com.aplicacaovacinas.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Entity
public class AplicacaoVacina {
  @Id
  @GeneratedValue
  private Long idVacinacao;

  @NotEmpty @NotNull
  private String nomeVacina;

  @PastOrPresent
  private LocalDate dataAplicacao;

  @NotNull
  @ManyToOne
  private Usuario usuario;

  public Long getIdVacinacao() {
    return idVacinacao;
  }

  public void setIdVacinacao(Long idVacinacao) {
    this.idVacinacao = idVacinacao;
  }

  public String getNomeVacina() {
    return nomeVacina;
  }

  public void setNomeVacina(String nomeVacina) {
    this.nomeVacina = nomeVacina;
  }

  public LocalDate getDataAplicacao() {
    return dataAplicacao;
  }

  public void setDataAplicacao(LocalDate dataAplicacao) {
    this.dataAplicacao = dataAplicacao;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}
