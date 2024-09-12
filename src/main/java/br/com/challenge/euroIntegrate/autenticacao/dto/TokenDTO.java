package br.com.challenge.euroIntegrate.autenticacao.dto;

import br.com.challenge.euroIntegrate.autenticacao.usuario.Role;
import br.com.challenge.euroIntegrate.autenticacao.usuario.RoleName;
import br.com.challenge.euroIntegrate.colaborador.dto.idColaboradorDTO;

public record TokenDTO(
        String token,
        Long idUser,
        String papel
) {
}
