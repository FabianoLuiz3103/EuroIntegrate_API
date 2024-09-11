package br.com.challenge.euroIntegrate.administrador.dto;

public record DadosHomeAdmin(

        String nomeAdmin,
        //Total de processos criados pelo admin e total geral
        Integer totalProcessos,
        Integer totalProcessosAdmin,
        Integer totalColaboradoresTreinados,
        Integer diasDeTreinamento,
        Integer qtdNaoInciado,
        Integer qtdFinalizado,
        Integer qtdAndamento


) {
}
