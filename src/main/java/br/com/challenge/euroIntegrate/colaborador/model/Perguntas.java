package br.com.challenge.euroIntegrate.colaborador.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name="tbl_perguntas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Perguntas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String enunciado;
    private String respostaCorreta;
    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_norma")
    private Normas norma;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_video")
    private Videos video;

    @OneToMany(mappedBy = "pergunta")
    private Set<Opcoes> opcoes = new LinkedHashSet<>();

}
