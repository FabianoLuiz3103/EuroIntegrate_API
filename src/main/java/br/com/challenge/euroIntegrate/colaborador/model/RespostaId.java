package br.com.challenge.euroIntegrate.colaborador.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class RespostaId implements Serializable {
    private Long colaboradorId;
    private Long perguntaId;
}
