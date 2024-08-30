package br.com.challenge.euroIntegrate.colaborador.dto;

import br.com.challenge.euroIntegrate.colaborador.model.Departamento;

public record DadosDepartamento(

        Long id,
        String nome
) {

    public DadosDepartamento(Departamento departamento){
        this(departamento.getId(), departamento.getNome());
    }
}
