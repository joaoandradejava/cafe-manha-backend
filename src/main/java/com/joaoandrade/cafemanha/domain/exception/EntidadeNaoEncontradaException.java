package com.joaoandrade.cafemanha.domain.exception;

public class EntidadeNaoEncontradaException extends CafeManhaException {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
}
