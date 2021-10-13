package com.joaoandrade.cafemanha.api.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joaoandrade.cafemanha.api.input.ColaboradorInput;
import com.joaoandrade.cafemanha.domain.model.Colaborador;

@Component
public class ColaboradorInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Colaborador toDomainModel(ColaboradorInput colaboradorInput) {
		return modelMapper.map(colaboradorInput, Colaborador.class);
	}

	public void copyToDomainModel(ColaboradorInput colaboradorInput, Colaborador colaborador) {
		modelMapper.map(colaboradorInput, colaborador);
	}
}
