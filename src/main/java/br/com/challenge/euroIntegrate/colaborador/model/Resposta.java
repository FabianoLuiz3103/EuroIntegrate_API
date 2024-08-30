package br.com.challenge.euroIntegrate.colaborador.model;

import br.com.challenge.euroIntegrate.colaborador.dto.DadosResposta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_respostas")
@IdClass(RespostaId.class)
public class Resposta {

    @Id
    @Column(name = "colaboradorId")
    private Long colaboradorId;

    @Id
    @Column(name = "perguntaId")
    private Long perguntaId;


    private String resposta;

    private Boolean foiRespondida = false;

    private LocalDate dataResposta;

    public Resposta(DadosResposta dadosResposta) {
        this.colaboradorId = dadosResposta.colaboradorId();
        this.perguntaId = dadosResposta.perguntaId();
        this.resposta = dadosResposta.resposta();
        this.foiRespondida = true;
        this.dataResposta = LocalDate.now();
    }

}
