package com.joaoandrade.cafemanha.domain.service.crud;

import com.joaoandrade.cafemanha.domain.exception.ColaboradorNaoEncontradoException;
import com.joaoandrade.cafemanha.domain.model.Colaborador;
import com.joaoandrade.cafemanha.domain.repository.ColaboradorRepository;
import com.joaoandrade.cafemanha.domain.service.validation.CpfUnicoValidator;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrudColaboradorService {

	@Autowired
	private ColaboradorRepository repository;

	@Autowired
	private CpfUnicoValidator cpfUnicoValidator;

	@Autowired
	private EntityManager entityManager;

	public Page<Colaborador> buscarTodos(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Colaborador buscarPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new ColaboradorNaoEncontradoException(id));
	}

	@Transactional
	public Colaborador inserir(Colaborador colaborador) {
		cpfUnicoValidator.validarCpfUnico(colaborador);

		return repository.save(colaborador);
	}

	@Transactional
	public Colaborador atualizar(Colaborador colaborador) {
		entityManager.detach(colaborador);
		cpfUnicoValidator.validarCpfUnico(colaborador);

		return repository.save(colaborador);
	}

	@Transactional
	public void deletarPorId(Long id) {
		buscarPorId(id);

		repository.deleteById(id);
	}

}
