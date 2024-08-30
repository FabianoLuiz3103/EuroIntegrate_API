package br.com.challenge.euroIntegrate.integracao.model;

import br.com.challenge.euroIntegrate.administrador.model.ColaboradorRh;
import br.com.challenge.euroIntegrate.colaborador.model.Colaborador;
import br.com.challenge.euroIntegrate.colaborador.model.Departamento;
import br.com.challenge.euroIntegrate.integracao.dto.DadosCadastroIntegracao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tbl_integracao")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"id"})
public class Integracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDate dataInicio;
    @NotNull
    private LocalTime horaInicio;
    @NotNull
    private LocalDate dataFim;
    @NotNull
    private LocalTime horaFim;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
    private Integer qtdColaboradores;
    private Double mediaProgresso;
    private Double mediaAcertos;

    @OneToMany(mappedBy = "integracao", fetch = FetchType.LAZY)
    private List<Colaborador> colaboradores = new ArrayList<>();

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rh", nullable = false)
    private ColaboradorRh colaboradorRh;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departamento", nullable = false)
    private Departamento departamento;


    public Integracao(DadosCadastroIntegracao dados, Integer qtdColaboradores, ColaboradorRh colaboradorRh){
        this.status = Status.ANDAMENTO;
        this.dataInicio = dados.dataInicio();
        this.dataFim = dados.dataFim();
        this.qtdColaboradores = qtdColaboradores;
        this.mediaAcertos = 0.0;
        this.mediaProgresso = 0.0;
        this.colaboradorRh = colaboradorRh;
        this.departamento = new Departamento(dados.departamento());


    }


}
