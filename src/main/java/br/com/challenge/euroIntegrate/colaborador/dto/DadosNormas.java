package br.com.challenge.euroIntegrate.colaborador.dto;

import br.com.challenge.euroIntegrate.colaborador.model.Normas;

import java.util.List;

public record DadosNormas(
        Long id,
        String nome,
        String descricao
) {

    public DadosNormas(Normas norma){
        this(
                norma.getId(),
                norma.getNome(),
                norma.getDescricao()
        );
    }
}
