package com.joaoandrade.cafemanha.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.joaoandrade.cafemanha.api.assembler.CafeManhaModelAssembler;
import com.joaoandrade.cafemanha.api.disassembler.CafeManhaInputDisassembler;
import com.joaoandrade.cafemanha.api.input.CafeManhaInput;
import com.joaoandrade.cafemanha.api.model.CafeManhaModel;
import com.joaoandrade.cafemanha.domain.model.CafeManha;
import com.joaoandrade.cafemanha.domain.model.Colaborador;
import com.joaoandrade.cafemanha.domain.service.ColaboradorCafeManhaService;
import com.joaoandrade.cafemanha.domain.service.crud.CrudColaboradorService;

@RestController
@RequestMapping("/colaboradores/{colaboradorId}/cafes")
public class ColaboradorCafeManhaController {

	@Autowired
	private CrudColaboradorService crudColaboradorService;

	@Autowired
	private CafeManhaModelAssembler cafeManhaModelAssembler;

	@Autowired
	private ColaboradorCafeManhaService colaboradorCafeManhaService;

	@Autowired
	private CafeManhaInputDisassembler cafeManhaInputDisassembler;

	@GetMapping
	public List<CafeManhaModel> buscarTodos(@PathVariable Long colaboradorId) {
		Colaborador colaborador = crudColaboradorService.buscarPorId(colaboradorId);

		return cafeManhaModelAssembler.toCollectionModel(colaborador.getCafes());
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public CafeManhaModel inserir(@Valid @RequestBody CafeManhaInput cafeManhaInput, @PathVariable Long colaboradorId) {
		CafeManha cafeManha = colaboradorCafeManhaService
				.inserir(cafeManhaInputDisassembler.toDomainModel(cafeManhaInput), colaboradorId);

		return cafeManhaModelAssembler.toModel(cafeManha);
	}

	@PutMapping("/{cafeManhaId}")
	public CafeManhaModel atualizar(@Valid @RequestBody CafeManhaInput cafeManhaInput, @PathVariable Long colaboradorId,
			@PathVariable Long cafeManhaId) {
		CafeManha cafeManha = colaboradorCafeManhaService.buscarPorId(colaboradorId, cafeManhaId);
		cafeManhaInputDisassembler.copyToDomainModel(cafeManhaInput, cafeManha);
		cafeManha = colaboradorCafeManhaService.atualizar(cafeManha);

		return cafeManhaModelAssembler.toModel(cafeManha);

	}

	@DeleteMapping("/{cafeManhaId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long colaboradorId, @PathVariable Long cafeManhaId) {
		colaboradorCafeManhaService.deletar(colaboradorId, cafeManhaId);
	}

}
