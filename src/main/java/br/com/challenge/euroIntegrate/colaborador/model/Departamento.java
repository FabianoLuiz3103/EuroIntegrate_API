package br.com.challenge.euroIntegrate.colaborador.model;

import br.com.challenge.euroIntegrate.colaborador.dto.DadosDepartamento;
import br.com.challenge.euroIntegrate.integracao.model.Integracao;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tbl_departamento")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"id"})
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "departamento")
    private List<Colaborador> colaboradores = new ArrayList<>();

    @OneToMany(mappedBy = "departamento")
    private List<Integracao> integracoes = new ArrayList<>();

    @OneToMany(mappedBy = "departamento")
    private List<Videos> videos = new ArrayList<>();

    @OneToMany(mappedBy = "departamento")
    private List<Normas> normas = new ArrayList<>();

    public Departamento(DadosDepartamento dados){
        this.id = dados.id();
        this.nome = dados.nome();
    }
}
