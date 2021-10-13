package com.joaoandrade.cafemanha.api.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joaoandrade.cafemanha.api.input.CafeManhaInput;
import com.joaoandrade.cafemanha.domain.model.CafeManha;

@Component
public class CafeManhaInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public CafeManha toDomainModel(CafeManhaInput cafeManhaInput) {
		return modelMapper.map(cafeManhaInput, CafeManha.class);
	}

	public void copyToDomainModel(CafeManhaInput cafeManhaInput, CafeManha cafeManha) {
		modelMapper.map(cafeManhaInput, cafeManha);
	}

}
