package br.com.challenge.euroIntegrate.administrador.dto;

import br.com.challenge.euroIntegrate.administrador.model.ColaboradorRh;
import br.com.challenge.euroIntegrate.colaborador.dto.DadosColaboradorPapelRh;

public record DadosColaboradorRh(

        Long id,
        String email,
        DadosColaboradorPapelRh dadosColaboradorPapelRh
) {
    public DadosColaboradorRh(ColaboradorRh colaboradorRh){
        this(
                colaboradorRh.getId(),
                colaboradorRh.getEmailRh(),
                new DadosColaboradorPapelRh(colaboradorRh.getColaborador())
                );
    }
}
