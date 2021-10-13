package com.joaoandrade.cafemanha.domain.exception;

public class ColaboradorNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public ColaboradorNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public ColaboradorNaoEncontradoException(Long id) {
		super(String.format("O Colaborador de id %d não foi encontrado no sistema!", id));
	}

}
