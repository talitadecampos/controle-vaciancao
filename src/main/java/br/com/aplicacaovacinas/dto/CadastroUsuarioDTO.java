package br.com.aplicacaovacinas.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;


public class CadastroUsuarioDTO {

	@NotEmpty
	@NotNull
	private String nome;

	@Email
	@Column(unique = true)
	@NotNull
	@NotEmpty
	private String email;

	@CPF
	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String cpf;

	@Past
	@NotNull
	private LocalDate dataNascto;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascto() {
		return dataNascto;
	}

	public void setDataNascto(LocalDate dataNascto) {
		this.dataNascto = dataNascto;
	}

	
	
	
	
}
