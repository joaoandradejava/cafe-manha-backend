package com.joaoandrade.cafemanha.api.exceptionhandler;

public enum Error {
	CAFE_MANHA_EXCEPTION("erro-client-side", "Aconteceu um erro do lado do client-side(front-end)"),
	ENTIDADE_NAO_ENCONTRADA_EXCEPTION("entidade-nao-encontrada", "Entidade não encontrada"),
	ERRO_VALIDACAO("erro-validacao", "Erro de validação"),
	ERRO_INTERNO_NO_SERVIDOR("erro-interno-no-servidor", "Erro interno no servidor");

	private String type;
	private String title;

	private Error(String type, String title) {
		this.type = "https://www.cafe-manha-joaoandrade.com.br/" + type;
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}

}
