package br.com.challenge.euroIntegrate.colaborador.dto;

import br.com.challenge.euroIntegrate.colaborador.model.Departamento;
import br.com.challenge.euroIntegrate.colaborador.model.Perguntas;
import br.com.challenge.euroIntegrate.colaborador.model.Videos;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record DadosVideos(
        Long id,
        String linkVideo,
        String nomeDepartamento,
        List<DadosPerguntas> perguntas

) {

    public DadosVideos(Videos videos, List<DadosPerguntas> perguntas){
        this(
                videos.getId(),
                videos.getLinkVideo(),
                videos.getDepartamento().getNome(),
                perguntas
        );
    }
}
