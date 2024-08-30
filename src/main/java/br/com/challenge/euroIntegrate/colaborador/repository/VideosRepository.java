package br.com.challenge.euroIntegrate.colaborador.repository;

import br.com.challenge.euroIntegrate.colaborador.model.Videos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideosRepository extends JpaRepository<Videos, Long> {
    @Query("SELECT v FROM Videos v LEFT JOIN FETCH v.perguntas p LEFT JOIN FETCH p.opcoes WHERE v.departamento.id = :idDept")
    List<Videos> findAllByDepartamentoIdWithPerguntasAndOpcoes(@Param("idDept") Long idDept);
}
