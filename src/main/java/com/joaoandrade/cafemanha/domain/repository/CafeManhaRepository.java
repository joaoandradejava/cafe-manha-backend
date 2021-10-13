package com.joaoandrade.cafemanha.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.joaoandrade.cafemanha.domain.model.CafeManha;

@Repository
public interface CafeManhaRepository extends JpaRepository<CafeManha, Long> {

	@Query("select c from CafeManha c where c.id = ?2 and c.colaborador.id = ?1")
	Optional<CafeManha> buscarCafeDoColaborador(Long colaboradorId, Long cafeManhaId);

	@Query("select c from CafeManha c where lower(c.nome) like lower(concat('%', ?1, '%'))")
	Optional<CafeManha> buscarPorNome(String nome);
}
