package br.com.aplicacaovacinas.entidades;

import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	@NotNull
	private String nome;

	@Email
	@NotEmpty
	@Column(unique = true)
	private String email;

	@CPF
	@Column(unique = true)
	private String cpf;

	@Past
	@NotNull
	private LocalDate dataNascto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public @Past @NotNull LocalDate getDataNascto() {
		return dataNascto;
	}

	public void setDataNascto(@Past @NotNull @Past @NotNull LocalDate dataNascto) {
		this.dataNascto = dataNascto;
	}
}
