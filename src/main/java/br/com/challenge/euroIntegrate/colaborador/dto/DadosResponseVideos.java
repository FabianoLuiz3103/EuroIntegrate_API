package br.com.challenge.euroIntegrate.colaborador.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosResponseVideos(

        @NotNull(message = "Obrigatório!")
        @Positive(message = "Deve ser um número positivo")
        Double porcProgresso,
        @NotNull(message = "Obrigatório!")
        @Positive(message = "Deve ser um número positivo")
        Integer pontuacao,
        @NotNull(message = "Obrigatório!")
        @Positive(message = "Deve ser um número positivo")
        Integer qtdRespondidas,
        @NotNull(message = "Obrigatório!")
        @Positive(message = "Deve ser um número positivo")
        Integer qtdCertas
) {

}
