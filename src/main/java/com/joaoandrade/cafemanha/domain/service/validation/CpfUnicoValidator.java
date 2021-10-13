package com.joaoandrade.cafemanha.domain.service.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joaoandrade.cafemanha.domain.exception.CafeManhaException;
import com.joaoandrade.cafemanha.domain.model.Colaborador;
import com.joaoandrade.cafemanha.domain.repository.ColaboradorRepository;

@Component
public class CpfUnicoValidator {

	@Autowired
	private ColaboradorRepository repository;

	public void validarCpfUnico(Colaborador colaborador) {
		Optional<Colaborador> obj = repository.findByCpf(colaborador.getCpf());

		if (obj.isPresent() && !obj.get().equals(colaborador)) {
			throw new CafeManhaException(String.format("O Cpf '%s' já existe!", colaborador.getCpf()));
		}
	}
}
