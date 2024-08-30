package br.com.challenge.euroIntegrate.colaborador.dto;

import br.com.challenge.euroIntegrate.colaborador.model.Normas;

import java.util.List;

public record DadosNormas(
        Long id,
        String nome,
        String descricao,
        List<DadosPerguntas> perguntas
) {

    public DadosNormas(Normas norma, List<DadosPerguntas> perguntas){
        this(
                norma.getId(),
                norma.getNome(),
                norma.getDescricao(),
                perguntas
        );
    }
}
