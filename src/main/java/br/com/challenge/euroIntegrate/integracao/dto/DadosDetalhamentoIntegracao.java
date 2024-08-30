package br.com.challenge.euroIntegrate.integracao.dto;

import br.com.challenge.euroIntegrate.administrador.dto.DadosColaboradorRh;
import br.com.challenge.euroIntegrate.administrador.model.ColaboradorRh;
import br.com.challenge.euroIntegrate.colaborador.dto.DadosDepartamento;
import br.com.challenge.euroIntegrate.integracao.model.Integracao;
import br.com.challenge.euroIntegrate.integracao.model.Status;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosDetalhamentoIntegracao(


                 Long id,
                 LocalDate dataInicio,
                 LocalTime horaInicio,
                 LocalDate dataFim,
                 LocalTime horaFim,
                 Status status,
                 Integer qtdColaboradores,
                 Double mediaProgresso,
                 Double mediaAcertos,
                 DadosColaboradorRh colaboradorRh,
                 DadosDepartamento departamento

) {

    public DadosDetalhamentoIntegracao(Integracao integracao){
        this(
                integracao.getId(),
                integracao.getDataInicio(),
                integracao.getHoraInicio(),
                integracao.getDataFim(),
                integracao.getHoraFim(),
                integracao.getStatus(),
                integracao.getQtdColaboradores(),
                integracao.getMediaProgresso(),
                integracao.getMediaAcertos(),
                new DadosColaboradorRh(integracao.getColaboradorRh()),
                new DadosDepartamento(integracao.getDepartamento())
        );
    }
}
