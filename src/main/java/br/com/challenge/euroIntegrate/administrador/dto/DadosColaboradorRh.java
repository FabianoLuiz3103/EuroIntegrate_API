package br.com.challenge.euroIntegrate.administrador.dto;

import br.com.challenge.euroIntegrate.administrador.model.ColaboradorRh;
import br.com.challenge.euroIntegrate.colaborador.dto.DadosColaboradorPapelRh;

public record DadosColaboradorRh(

        Long id,
        String cpf

) {

    public DadosColaboradorRh(ColaboradorRh dados){
        this(dados.getId(),
                dados.getCpf());
    }

}
