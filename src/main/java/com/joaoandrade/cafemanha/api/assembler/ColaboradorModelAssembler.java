package com.joaoandrade.cafemanha.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joaoandrade.cafemanha.api.model.ColaboradorModel;
import com.joaoandrade.cafemanha.domain.model.Colaborador;

@Component
public class ColaboradorModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public ColaboradorModel toModel(Colaborador colaborador) {
		return modelMapper.map(colaborador, ColaboradorModel.class);
	}

	public List<ColaboradorModel> toCollectionModel(List<Colaborador> lista) {
		return lista.stream().map(colaborador -> toModel(colaborador)).collect(Collectors.toList());
	}
}
