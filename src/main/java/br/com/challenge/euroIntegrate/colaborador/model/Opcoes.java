package br.com.challenge.euroIntegrate.colaborador.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tbl_opcoes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"id"})
public class Opcoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String opcao;
    private String texto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pergunta")
    private Perguntas pergunta;

}
