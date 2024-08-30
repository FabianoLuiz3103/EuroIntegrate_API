package br.com.challenge.euroIntegrate.colaborador.dto;

import br.com.challenge.euroIntegrate.colaborador.model.Colaborador;

public record DadosColaboradorPapelRh(

        String nome
) {

    public DadosColaboradorPapelRh(Colaborador colaborador){
        this(colaborador.getPrimeiroNome());
    }
}
