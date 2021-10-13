package com.joaoandrade.cafemanha.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joaoandrade.cafemanha.api.model.CafeManhaModel;
import com.joaoandrade.cafemanha.domain.model.CafeManha;

@Component
public class CafeManhaModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public CafeManhaModel toModel(CafeManha cafeManha) {
		return modelMapper.map(cafeManha, CafeManhaModel.class);
	}

	public List<CafeManhaModel> toCollectionModel(List<CafeManha> lista) {
		return lista.stream().map(cafeManha -> toModel(cafeManha)).collect(Collectors.toList());
	}
}
