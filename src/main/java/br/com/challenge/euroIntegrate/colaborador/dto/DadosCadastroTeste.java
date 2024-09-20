package br.com.challenge.euroIntegrate.colaborador.dto;

import br.com.challenge.euroIntegrate.integracao.dto.DadosIntegracao;

import java.time.LocalDate;

public record DadosCadastroTeste(
        String primeiroNome,
        String sobrenome,
        String cpf,
        String email,
        String telefone,
        LocalDate dataAdmissao,
        Integer qtdRespondidas,
        Integer pontuacao,
        Integer qtdCertas,
        Double porcProgresso,
        String matricula,
        LocalDate dataNascimento,
        Double porcAcertos,
        DadosDepartamento departamento

) {
}
