package br.com.challenge.euroIntegrate.autenticacao.dto;

import br.com.challenge.euroIntegrate.autenticacao.usuario.Role;

import java.util.List;

public record RecuperarUsuarioDTO(

        Long id,
        String email,
        List<Role> roles
) {
}
