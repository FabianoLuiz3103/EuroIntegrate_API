package br.com.challenge.euroIntegrate.colaborador.dto;

import java.util.List;

public record DadosTelaNormas(
        DadosNormas normas,
        List<DadosPerguntas> perguntas
) {

}
