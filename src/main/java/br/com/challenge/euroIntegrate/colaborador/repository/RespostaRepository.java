package br.com.challenge.euroIntegrate.colaborador.repository;

import br.com.challenge.euroIntegrate.colaborador.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {

    @Query("SELECT r FROM Resposta r WHERE r.colaboradorId = :idColaborador")
    List<Resposta> findAllByColaboradorId(@Param("idColaborador") Long idColaborador);
}
