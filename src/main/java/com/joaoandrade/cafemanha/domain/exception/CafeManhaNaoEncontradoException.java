package com.joaoandrade.cafemanha.domain.exception;

public class CafeManhaNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public CafeManhaNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public CafeManhaNaoEncontradoException(Long id) {
		super(String.format("O Café da Manhã de id %d não foi encontrado no sistema!", id));
	}

}
