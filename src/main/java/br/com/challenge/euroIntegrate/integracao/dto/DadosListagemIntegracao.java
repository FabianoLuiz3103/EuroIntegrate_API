package br.com.challenge.euroIntegrate.integracao.dto;

import br.com.challenge.euroIntegrate.administrador.dto.DadosColaboradorRh;
import br.com.challenge.euroIntegrate.colaborador.dto.DadosDepartamento;
import br.com.challenge.euroIntegrate.integracao.model.Integracao;
import br.com.challenge.euroIntegrate.integracao.model.Status;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosListagemIntegracao(

        Long id,
        LocalDate dataInicio,
        LocalTime horaInicio,
        LocalDate dataFim,
        LocalTime horaFim,
        Status status,
        Integer qtdColaboradores,
        DadosDepartamento departamento,
        Double mediaProgresso,
        Double mediaAcertos,
        DadosColaboradorRh rh
) {

    public DadosListagemIntegracao(Integracao integracao){
        this(
                integracao.getId(),
                integracao.getDataInicio(),
                integracao.getHoraInicio(),
                integracao.getDataFim(),
                integracao.getHoraFim(),
                integracao.getStatus(),
                integracao.getQtdColaboradores(),
                new DadosDepartamento(integracao.getDepartamento()),
                integracao.getMediaProgresso(),
                integracao.getMediaAcertos(),
                new DadosColaboradorRh(integracao.getColaboradorRh())
                );
    }
}
