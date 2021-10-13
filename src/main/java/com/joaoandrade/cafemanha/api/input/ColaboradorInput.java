package com.joaoandrade.cafemanha.api.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class ColaboradorInput {

	@Size(min = 3, max = 255)
	@NotBlank
	private String nome;

	@Size(max = 11)
	@CPF
	@NotBlank
	private String cpf;

	public ColaboradorInput() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
