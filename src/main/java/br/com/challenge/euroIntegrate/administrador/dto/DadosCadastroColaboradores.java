package br.com.challenge.euroIntegrate.administrador.dto;

import br.com.challenge.euroIntegrate.colaborador.dto.DadosDepartamento;

import java.time.LocalDate;

public record DadosCadastroColaboradores(

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
}
