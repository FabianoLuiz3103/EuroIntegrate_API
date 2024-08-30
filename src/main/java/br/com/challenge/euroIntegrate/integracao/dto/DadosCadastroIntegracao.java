package br.com.challenge.euroIntegrate.integracao.dto;

import br.com.challenge.euroIntegrate.colaborador.dto.DadosDepartamento;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosCadastroIntegracao(

                @NotNull
                 LocalDate dataInicio,
                @NotNull
                LocalTime horaInicio,
                @NotNull
                 LocalDate dataFim,
                @NotNull
                 LocalTime horaFim,
                DadosDepartamento departamento
) {
}
