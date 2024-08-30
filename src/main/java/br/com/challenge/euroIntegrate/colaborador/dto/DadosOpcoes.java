package br.com.challenge.euroIntegrate.colaborador.dto;

import br.com.challenge.euroIntegrate.colaborador.model.Opcoes;

public record DadosOpcoes(
        Long id,
        String opcao,
        String texto
) {

    public DadosOpcoes(Opcoes opcao){
        this(
                opcao.getId(),
                opcao.getOpcao(),
                opcao.getTexto()
        );
    }
}
