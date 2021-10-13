package com.joaoandrade.cafemanha.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaoandrade.cafemanha.domain.model.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

	Optional<Colaborador> findByCpf(String cpf);

}
