package br.com.challenge.euroIntegrate.colaborador.dto;

import br.com.challenge.euroIntegrate.colaborador.model.Colaborador;
import br.com.challenge.euroIntegrate.integracao.model.Status;
import jakarta.persistence.Column;

import java.time.LocalDate;

public record DadosDetalhamentoColaborador(
        Long id,
        String primeiroNome,
        String sobrenome,
        String cpf,
        String email,
        String telefone,
        LocalDate dataAdmissao,
        String avatar,
        Status stsIntegracao,
        Integer qtdRespondidas,
        Integer pontuacao,
        Integer qtdCertas,
        Double porcProgresso,
        Double porcAcertos,
        String matricula,
        LocalDate dataNascimento,
        DadosDepartamento departamento
) {

    public DadosDetalhamentoColaborador(Colaborador colaborador){
        this(
                colaborador.getId(),
                colaborador.getPrimeiroNome(),
                colaborador.getSobrenome(),
                colaborador.getCpf(),
                colaborador.getEmail(),
                colaborador.getTelefone(),
                colaborador.getDataAdmissao(),
                colaborador.getAvatar(),
                colaborador.getStsIntegracao(),
                colaborador.getQtdRespondidas(),
                colaborador.getPontuacao(),
                colaborador.getQtdCertas(),
                colaborador.getPorcProgresso(),
                colaborador.getPorcAcertos(),
                colaborador.getNumeroMatricula(),
                colaborador.getDataNascimento(),
                new DadosDepartamento(colaborador.getDepartamento())
        );
    }
}
