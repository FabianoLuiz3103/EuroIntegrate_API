package br.com.challenge.euroIntegrate.colaborador.repository;

import br.com.challenge.euroIntegrate.colaborador.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
