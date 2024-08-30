package br.com.challenge.euroIntegrate.colaborador.dto;

import br.com.challenge.euroIntegrate.colaborador.model.Resposta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosResposta(

        @NotNull
        Long colaboradorId,
        @NotNull
        Long perguntaId,
        @NotBlank
        String resposta
) {

    public DadosResposta(Resposta resposta){
        this(
                resposta.getColaboradorId(),
                resposta.getPerguntaId(),
                resposta.getResposta()
        );
    }
}
