package com.joaoandrade.cafemanha.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joaoandrade.cafemanha.domain.model.Colaborador;

import com.joaoandrade.cafemanha.api.model.ColaboradorFullModel;

@Component
public class ColaboradorFullModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public ColaboradorFullModel toModel(Colaborador colaborador) {
		return modelMapper.map(colaborador, ColaboradorFullModel.class);
	}
}
