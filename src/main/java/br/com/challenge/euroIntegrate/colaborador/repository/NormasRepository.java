package br.com.challenge.euroIntegrate.colaborador.repository;

import br.com.challenge.euroIntegrate.colaborador.model.Normas;
import br.com.challenge.euroIntegrate.colaborador.model.Videos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NormasRepository extends JpaRepository<Normas, Long> {

    @Query("SELECT n FROM Normas n LEFT JOIN FETCH n.perguntas p LEFT JOIN FETCH p.opcoes WHERE n.departamento.id IS NULL")
    List<Normas> findAllByDepartamentoIdIsNull();

    @Query("SELECT n FROM Normas n LEFT JOIN FETCH n.perguntas p LEFT JOIN FETCH p.opcoes WHERE n.departamento.id = :idDept")
    List<Normas> findAllByDepartamentoIdWithPerguntasAndOpcoes(@Param("idDept") Long idDept);
}
