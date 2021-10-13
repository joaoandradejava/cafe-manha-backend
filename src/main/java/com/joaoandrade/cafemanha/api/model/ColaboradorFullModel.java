package com.joaoandrade.cafemanha.api.model;

import java.util.ArrayList;
import java.util.List;

public class ColaboradorFullModel {
	private Long id;
	private String nome;
	private String cpf;
	private List<CafeManhaModel> cafes = new ArrayList<>();

	public ColaboradorFullModel() {
	}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<CafeManhaModel> getCafes() {
		return cafes;
	}

	public void setCafes(List<CafeManhaModel> cafes) {
		this.cafes = cafes;
	}

}
