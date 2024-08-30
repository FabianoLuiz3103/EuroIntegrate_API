package br.com.challenge.euroIntegrate.colaborador.repository;

import br.com.challenge.euroIntegrate.colaborador.model.Perguntas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerguntaRepository extends JpaRepository<Perguntas, Long> {
}
