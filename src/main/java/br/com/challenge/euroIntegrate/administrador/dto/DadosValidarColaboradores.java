package br.com.challenge.euroIntegrate.administrador.dto;

import br.com.challenge.euroIntegrate.colaborador.dto.DadosDepartamento;
import br.com.challenge.euroIntegrate.colaborador.model.Colaborador;

import java.time.LocalDate;

public record DadosValidarColaboradores(

        String nome,
        String sobrenome,
        String cpf,
        String email,
        String telefone,
        LocalDate dataAdmissao,
        String matricula,
        LocalDate dataNascimento,
        DadosDepartamento departamento
) {

    public DadosValidarColaboradores(Colaborador colaborador){
        this(
                colaborador.getPrimeiroNome(),
                colaborador.getSobrenome(),
                colaborador.getCpf(),
                colaborador.getEmail(),
                colaborador.getTelefone(),
                colaborador.getDataAdmissao(),
                colaborador.getNumeroMatricula(),
                colaborador.getDataNascimento(),
                new DadosDepartamento(colaborador.getDepartamento())
        );
    }
}
