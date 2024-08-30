package br.com.challenge.euroIntegrate.colaborador.dto;

import br.com.challenge.euroIntegrate.colaborador.model.RespostaId;

public record DadosIdResposta(
        Long colaboradorId,
        Long perguntaId
) {
    public DadosIdResposta(RespostaId respostaId){
        this(
                respostaId.getColaboradorId(),
                respostaId.getPerguntaId()
        );
    }
}
