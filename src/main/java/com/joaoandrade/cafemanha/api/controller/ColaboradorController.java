package com.joaoandrade.cafemanha.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.joaoandrade.cafemanha.api.assembler.ColaboradorFullModelAssembler;
import com.joaoandrade.cafemanha.api.assembler.ColaboradorModelAssembler;
import com.joaoandrade.cafemanha.api.disassembler.ColaboradorInputDisassembler;
import com.joaoandrade.cafemanha.api.input.ColaboradorInput;
import com.joaoandrade.cafemanha.api.model.ColaboradorFullModel;
import com.joaoandrade.cafemanha.api.model.ColaboradorModel;
import com.joaoandrade.cafemanha.domain.dto.FiltroColaborador;
import com.joaoandrade.cafemanha.domain.model.Colaborador;
import com.joaoandrade.cafemanha.domain.service.crud.CrudColaboradorService;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

	@Autowired
	private CrudColaboradorService crudColaboradorService;

	@Autowired
	private ColaboradorModelAssembler colaboradorModelAssembler;

	@Autowired
	private ColaboradorFullModelAssembler colaboradorFullModelAssembler;

	@Autowired
	private ColaboradorInputDisassembler colaboradorInputDisassembler;

	@GetMapping
	public Page<ColaboradorModel> buscarTodos(Pageable pageable, FiltroColaborador filtroColaborador) {
		Page<Colaborador> page = crudColaboradorService.buscarTodos(pageable, filtroColaborador);

		return page.map(colaborador -> colaboradorModelAssembler.toModel(colaborador));
	}

	@GetMapping("/{id}")
	public ColaboradorFullModel buscarPorId(@PathVariable Long id) {
		Colaborador colaborador = crudColaboradorService.buscarPorId(id);

		return colaboradorFullModelAssembler.toModel(colaborador);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ColaboradorFullModel inserir(@Valid @RequestBody ColaboradorInput colaboradorInput) {
		Colaborador colaborador = crudColaboradorService
				.inserir(colaboradorInputDisassembler.toDomainModel(colaboradorInput));

		return colaboradorFullModelAssembler.toModel(colaborador);
	}

	@PutMapping("/{id}")
	public ColaboradorFullModel atualizar(@Valid @RequestBody ColaboradorInput colaboradorInput,
			@PathVariable Long id) {
		Colaborador colaborador = crudColaboradorService.buscarPorId(id);
		colaboradorInputDisassembler.copyToDomainModel(colaboradorInput, colaborador);
		colaborador = crudColaboradorService.atualizar(colaborador);

		return colaboradorFullModelAssembler.toModel(colaborador);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deletarPorId(@PathVariable Long id) {
		crudColaboradorService.deletarPorId(id);
	}

}
