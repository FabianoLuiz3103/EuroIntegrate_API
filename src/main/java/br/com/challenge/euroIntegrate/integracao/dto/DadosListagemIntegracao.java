package br.com.challenge.euroIntegrate.integracao.dto;

import br.com.challenge.euroIntegrate.colaborador.dto.DadosDepartamento;
import br.com.challenge.euroIntegrate.integracao.model.Integracao;
import br.com.challenge.euroIntegrate.integracao.model.Status;

import java.time.LocalDate;

public record DadosListagemIntegracao(

        Long id,
        DadosDepartamento departamento,
        Status status,
        LocalDate dataInicio,
        LocalDate dataFim
) {

    public DadosListagemIntegracao(Integracao integracao){
        this(
                integracao.getId(),
                new DadosDepartamento(integracao.getDepartamento()),
                integracao.getStatus(),
                integracao.getDataInicio(),
                integracao.getDataFim()
                );
    }
}
