package br.com.challenge.euroIntegrate.colaborador.dto;

import br.com.challenge.euroIntegrate.colaborador.model.Colaborador;
import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoAvatar(
        @NotBlank
        String avatar,
        String avatarSVG
) {

        public DadosAtualizacaoAvatar(Colaborador colaborador){
                this(colaborador.getAvatar(),
                        colaborador.getAvatarSVG()
                );
        }
}
