package br.com.challenge.euroIntegrate.colaborador.dto;

import java.util.List;

public record DadosAuxVideosNormas(
        Long idColaborador,
        Double porcProgresso,
        Integer pontuacao,
        Integer qtdRespondidas,
        Integer qtdCertas,
        List<DadosDetalhamentoResposta> respostas
) {

}
