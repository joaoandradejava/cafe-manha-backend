package com.joaoandrade.cafemanha.domain.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoandrade.cafemanha.domain.exception.CafeManhaException;
import com.joaoandrade.cafemanha.domain.exception.CafeManhaNaoEncontradoException;
import com.joaoandrade.cafemanha.domain.model.CafeManha;
import com.joaoandrade.cafemanha.domain.model.Colaborador;
import com.joaoandrade.cafemanha.domain.repository.CafeManhaRepository;
import com.joaoandrade.cafemanha.domain.service.crud.CrudColaboradorService;
import com.joaoandrade.cafemanha.domain.service.validation.NomeCafeManhaUnicoValidator;

@Service
public class ColaboradorCafeManhaService {

	@Autowired
	private CrudColaboradorService crudColaboradorService;

	@Autowired
	private CafeManhaRepository repository;

	@Autowired
	private NomeCafeManhaUnicoValidator nomeCafeManhaUnicoValidator;

	@Autowired
	private EntityManager entityManager;

	public CafeManha buscarPorId(Long colaboradorId, Long cafeManhaId) {
		crudColaboradorService.buscarPorId(colaboradorId);
		repository.findById(cafeManhaId).orElseThrow(() -> new CafeManhaNaoEncontradoException(cafeManhaId));

		return repository.buscarCafeDoColaborador(colaboradorId, cafeManhaId)
				.orElseThrow(() -> new CafeManhaException(
						String.format("O Café da manhã de id %d não está associado com o Colaborador de id %d",
								cafeManhaId, colaboradorId)));
	}

	@Transactional
	public CafeManha inserir(CafeManha cafeManha, Long colaboradorId) {
		Colaborador colaborador = crudColaboradorService.buscarPorId(colaboradorId);
		cafeManha.setColaborador(colaborador);
		nomeCafeManhaUnicoValidator.validarNomeUnico(cafeManha);

		return repository.save(cafeManha);
	}

	@Transactional
	public CafeManha atualizar(CafeManha cafeManha) {
		entityManager.detach(cafeManha);
		nomeCafeManhaUnicoValidator.validarNomeUnico(cafeManha);

		return repository.save(cafeManha);
	}

	@Transactional
	public void deletar(Long colaboradorId, Long cafeManhaId) {
		buscarPorId(colaboradorId, cafeManhaId);

		repository.deleteById(cafeManhaId);
	}

}
