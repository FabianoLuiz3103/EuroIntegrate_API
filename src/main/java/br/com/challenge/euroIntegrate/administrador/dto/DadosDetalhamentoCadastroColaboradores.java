package br.com.challenge.euroIntegrate.administrador.dto;

import br.com.challenge.euroIntegrate.colaborador.dto.DadosDepartamento;
import br.com.challenge.euroIntegrate.colaborador.model.Colaborador;

public record DadosDetalhamentoCadastroColaboradores(

        String nome,
        String sobrenome,
        String matricula,
        DadosDepartamento departamento
) {

    public DadosDetalhamentoCadastroColaboradores(Colaborador colaborador){
        this(
                colaborador.getPrimeiroNome(),
                colaborador.getSobrenome(),
                colaborador.getNumeroMatricula(),
                new DadosDepartamento(colaborador.getDepartamento())
        );
    }
}
