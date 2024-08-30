package br.com.challenge.euroIntegrate.colaborador.dto;

import br.com.challenge.euroIntegrate.colaborador.model.Colaborador;
import br.com.challenge.euroIntegrate.colaborador.model.Departamento;
import br.com.challenge.euroIntegrate.integracao.model.Status;

import java.time.LocalDate;

public record DadosHomeColaborador(

        String primeiroNome,
        String avatar,
        Integer pontuacao,
        Double porcProgresso,
        Integer qtdRespondidas,
        Integer qtdCertas,
        Status stsIntegracao,
        DadosDepartamento departamento,
        LocalDate dataInicio,
        LocalDate dataFim
) {
    public DadosHomeColaborador(Colaborador colaborador){
        this(
                colaborador.getPrimeiroNome(),
                colaborador.getAvatar(),
                colaborador.getPontuacao(),
                colaborador.getPorcProgresso(),
                colaborador.getQtdRespondidas(),
                colaborador.getQtdCertas(),
                colaborador.getStsIntegracao(),
                new DadosDepartamento(colaborador.getDepartamento()),
                colaborador.getIntegracao() != null ? colaborador.getIntegracao().getDataInicio() : null,
                colaborador.getIntegracao() != null ? colaborador.getIntegracao().getDataFim() : null
        );
    }
}
