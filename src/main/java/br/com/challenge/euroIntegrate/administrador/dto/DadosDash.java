package br.com.challenge.euroIntegrate.administrador.dto;

import java.util.List;
import java.util.Map;

public record DadosDash(

        List<Integer> anosIntegracao,
        List<Integer> idades,
        List<Integer> respondidas,
        List<Integer> certas,
        Map<String, Double> mediaPorgresso,
        Map<String, Double> mediaAcertos,
        Map<String, Long> quantidadeProcessos
) {
}
