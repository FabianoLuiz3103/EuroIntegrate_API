package br.com.challenge.euroIntegrate.colaborador.dto;

import br.com.challenge.euroIntegrate.colaborador.model.Perguntas;

import java.util.List;

public record DadosPerguntas(
        Long id,
        String enunciado,
        String respostaCorreta,
        String tipo,
        List<DadosOpcoes> opcoes
) {

    public DadosPerguntas(Perguntas pergunta, List<DadosOpcoes> opcoes){
        this(
                pergunta.getId(),
                pergunta.getEnunciado(),
                pergunta.getRespostaCorreta(),
                pergunta.getTipo(),
                opcoes
        );
    }
}
