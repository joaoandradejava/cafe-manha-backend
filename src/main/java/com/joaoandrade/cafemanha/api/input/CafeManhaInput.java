package com.joaoandrade.cafemanha.api.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CafeManhaInput {

	@Size(max = 255)
	@NotBlank
	private String nome;

	public CafeManhaInput() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
