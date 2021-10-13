package com.joaoandrade.cafemanha.domain.exception;

public class CafeManhaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CafeManhaException(String mensagem) {
		super(mensagem);
	}

}
