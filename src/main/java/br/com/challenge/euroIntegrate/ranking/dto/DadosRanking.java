package br.com.challenge.euroIntegrate.ranking.dto;

import br.com.challenge.euroIntegrate.colaborador.dto.DadosDepartamento;
import br.com.challenge.euroIntegrate.integracao.model.Status;

import java.time.LocalDate;

public record DadosRanking(
        String avatar,
        String primeiroNome,
        String sobrenome,
        Integer pontuacao,
        DadosDepartamento departamento,
        Status stsIntegracao,
        LocalDate dataInicio,
        LocalDate dataFim
) {


}
