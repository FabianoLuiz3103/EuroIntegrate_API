package br.com.challenge.euroIntegrate.integracao.repository;

import br.com.challenge.euroIntegrate.integracao.model.Integracao;
import br.com.challenge.euroIntegrate.integracao.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IntegracaoRepository extends JpaRepository<Integracao, Long> {
    List<Integracao> findAllByColaboradorRhId(Long idRh);

    @Modifying
    @Query("UPDATE Integracao i SET i.status = :status WHERE i.id = :idInt")
    void atualizarStatusInicio(@Param("status") Status status, @Param("idInt") Long idInt);

    @Query("SELECT i.id, i.dataInicio, i.horaInicio FROM Integracao i WHERE i.status = 'NAO_INICIADO'")
    List<Object[]> findDataHoraInicioByStatusNaoFez();

}
