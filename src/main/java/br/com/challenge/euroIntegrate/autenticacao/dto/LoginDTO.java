package br.com.challenge.euroIntegrate.autenticacao.dto;

import br.com.challenge.euroIntegrate.autenticacao.usuario.RoleName;

public record LoginDTO(
        String cpf,
        String senha
) {
}
