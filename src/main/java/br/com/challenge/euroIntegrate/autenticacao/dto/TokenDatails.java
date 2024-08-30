package br.com.challenge.euroIntegrate.autenticacao.dto;

import br.com.challenge.euroIntegrate.colaborador.dto.idColaboradorDTO;

public record TokenDatails(
        TokenDTO token,
        idColaboradorDTO idColaborador
) {
}
