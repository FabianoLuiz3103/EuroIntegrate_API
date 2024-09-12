package br.com.challenge.euroIntegrate.administrador.dto;

public record DadosHomeAdmin(

        String nomeAdmin,
        //Total de processos criados pelo admin e total geral
        Long totalProcessos,
        Integer totalProcessosAdmin,
        Integer totalColaboradoresTreinados,
        Long diasDeTreinamento,
        Integer qtdNaoIniciado,
        Integer qtdFinalizado,
        Integer qtdAndamento


) {
}
