package com.joaoandrade.cafemanha.domain.service.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joaoandrade.cafemanha.domain.exception.CafeManhaException;
import com.joaoandrade.cafemanha.domain.model.CafeManha;
import com.joaoandrade.cafemanha.domain.repository.CafeManhaRepository;

@Component
public class NomeCafeManhaUnicoValidator {

	@Autowired
	private CafeManhaRepository repository;

	public void validarNomeUnico(CafeManha cafeManha) {
		Optional<CafeManha> obj = repository.buscarPorNome(cafeManha.getNome());

		if (obj.isPresent() && !obj.get().equals(cafeManha)) {
			throw new CafeManhaException(String.format(
					"Um colaborador Já trouxe um '%s' para o café da manhã, por favor traga outro café da manhã",
					cafeManha.getNome()));
		}
	}
}
