package br.com.aplicacaovacinas.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class AplicacaoVacinaDTO {
  private String nomeUsuario;
  private String CPF;

  @NotNull
  @NotEmpty
  private String email;

  @NotNull
  @NotEmpty
  private String nomeVacina;

  @PastOrPresent
  private LocalDate dataAplicacao;

  public String getNomeUsuario() {
    return nomeUsuario;
  }

  public void setNomeUsuario(String nomeUsuario) {
    this.nomeUsuario = nomeUsuario;
  }

  public String getCPF() {
    return CPF;
  }

  public void setCPF(String CPF) {
    this.CPF = CPF;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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
}
