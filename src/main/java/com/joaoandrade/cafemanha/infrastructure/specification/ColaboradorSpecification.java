package com.joaoandrade.cafemanha.infrastructure.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.joaoandrade.cafemanha.domain.dto.FiltroColaborador;
import com.joaoandrade.cafemanha.domain.model.Colaborador;

public class ColaboradorSpecification {

	public static Specification<Colaborador> filtrarColaborador(FiltroColaborador filtroColaborador) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.hasLength(filtroColaborador.getNome())) {
				predicates.add(
						cb.like(cb.upper(root.get("nome")), "%" + filtroColaborador.getNome().toUpperCase() + "%"));
			}

			if (StringUtils.hasLength(filtroColaborador.getCpf())) {
				predicates.add(cb.like(root.get("cpf"), "%" + filtroColaborador.getCpf() + "%"));
			}

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

}
