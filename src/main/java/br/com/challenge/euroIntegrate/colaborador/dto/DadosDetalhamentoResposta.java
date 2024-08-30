package br.com.challenge.euroIntegrate.colaborador.dto;

import br.com.challenge.euroIntegrate.colaborador.model.Resposta;
import br.com.challenge.euroIntegrate.colaborador.model.RespostaId;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DadosDetalhamentoResposta(

        DadosIdResposta respostaId,
        String resposta,
        Boolean foiRespondida,
        LocalDate dataResposta
) {

    public DadosDetalhamentoResposta(Resposta resposta){
        this(
                new DadosIdResposta(resposta.getColaboradorId(), resposta.getPerguntaId()),
                resposta.getResposta(),
                resposta.getFoiRespondida(),
                resposta.getDataResposta()
        );
    }
}
