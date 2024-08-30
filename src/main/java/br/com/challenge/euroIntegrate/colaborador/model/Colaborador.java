package br.com.challenge.euroIntegrate.colaborador.model;

import br.com.challenge.euroIntegrate.administrador.model.ColaboradorRh;
import br.com.challenge.euroIntegrate.colaborador.dto.DadosAtualizacaoAvatar;
import br.com.challenge.euroIntegrate.colaborador.dto.DadosResponseVideos;
import br.com.challenge.euroIntegrate.integracao.model.Integracao;
import br.com.challenge.euroIntegrate.integracao.model.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tbl_colaborador")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String primeiroNome;
    private String sobrenome;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String telefone;
    private LocalDate dataAdmissao;
    @Column(length = 500)
    private String avatar;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status stsIntegracao;
    private Integer qtdRespondidas;
    private Integer pontuacao;
    private Integer qtdCertas;
    private Double porcProgresso;
    private Double porcAcertos;
    private String numeroMatricula;
    private LocalDate dataNascimento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departamento", nullable = false)
    private Departamento departamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_integracao")
    private Integracao integracao;

    @OneToOne(mappedBy = "colaborador")
    private ColaboradorRh colaboradorRh;


    public void atualizarAvatar(DadosAtualizacaoAvatar dados){
        if(dados.avatar() != null){
            this.avatar = dados.avatar();
        }
    }

    public void atualizarDados(DadosResponseVideos dados){
        if(dados.porcProgresso() != null){
            this.porcProgresso = dados.porcProgresso();
        }
        if(dados.pontuacao() != null){
            this.pontuacao = dados.pontuacao();
        }
        if(dados.qtdRespondidas() != null){
            this.qtdRespondidas = dados.qtdRespondidas();
        }
        if(dados.qtdCertas() != null){
            this.qtdCertas = dados.qtdCertas();
        }
    }
}
