package br.com.challenge.euroIntegrate.colaborador.repository;

import br.com.challenge.euroIntegrate.autenticacao.usuario.Usuario;
import br.com.challenge.euroIntegrate.colaborador.dto.InfosColaboradorTelaVideos;
import br.com.challenge.euroIntegrate.colaborador.model.Colaborador;
import br.com.challenge.euroIntegrate.integracao.model.Integracao;
import br.com.challenge.euroIntegrate.integracao.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    @Query("SELECT id FROM Colaborador WHERE email = :email")
    Optional<Long> findIdByEmail(@Param("email") String email);
    @Query("SELECT c.departamento.id FROM Colaborador c WHERE c.id = :id")
    Optional<Long> findDepartamentoIdById(@Param("id") Long id);

    @Query("SELECT new br.com.challenge.euroIntegrate.colaborador.dto.InfosColaboradorTelaVideos(c.id, c.porcProgresso, c.pontuacao, c.qtdRespondidas, c.qtdCertas) " +
            "FROM Colaborador c WHERE c.id = :id")
    Optional<InfosColaboradorTelaVideos> findColaboradorInfoById(@Param("id") Long id);


    @Query("SELECT COUNT(c) FROM Colaborador c WHERE c.departamento.id = :idDept AND c.stsIntegracao = 'NAO_FEZ'")
    int countByDepartamentoIdAndStatus(@Param("idDept") Long idDept);

    @Modifying
    @Query("UPDATE Colaborador c SET c.integracao = :integracao, c.stsIntegracao = :status WHERE c.departamento.id = :idDept AND c.stsIntegracao = 'NAO_FEZ'")
    void updateIntegracaoByDepartamentoId(@Param("integracao") Integracao integracao, @Param("status") Status status, @Param("idDept") Long idDept);

    @Modifying
    @Query("UPDATE Colaborador c SET c.stsIntegracao = :status WHERE c.integracao.id = :idInt AND c.stsIntegracao = 'NAO_FEZ'")
    void atualizarStatusInicio(@Param("status") Status status, @Param("idInt") Long idInt);


}
