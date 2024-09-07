package br.com.challenge.euroIntegrate.colaborador.model;

import br.com.challenge.euroIntegrate.administrador.dto.DadosCadastroColaboradores;
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
    @Column(length = 800)
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


    public Colaborador(DadosCadastroColaboradores dados){
        this.primeiroNome = dados.nome();
        this.sobrenome = dados.sobrenome();
        this.cpf = dados.cpf();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.dataAdmissao = dados.dataAdmissao();
        this.dataNascimento = dados.dataNascimento();
        this.numeroMatricula = dados.matricula();
        this.departamento = new Departamento(dados.departamento());
        this.colaboradorRh = new ColaboradorRh(dados.colaboradorRh());
        this.avatar = "{\"HairStyle\":\"Bald\",\"HairColor\":\"Auburn\",\"FacialHairType\":\"Nothing\",\"FacialHairColor\":\"Auburn\",\"EyeType\":\"Close\",\"EyebrowType\":\"Angry\",\"Nose\":\"Default\",\"MouthType\":\"Concerned\",\"SkinColor\":\"Tanned\",\"OutfitType\":\"BlazerTShirt\",\"OutfitColor\":\"Black\",\"Accessory\":\"Nothing\",\"Background\":\"Transparent\"}";
        this.stsIntegracao = Status.NAO_FEZ;
        this.pontuacao = 0;
        this.qtdRespondidas = 0;
        this.qtdCertas = 0;
        this.porcProgresso = 0.0;
        this.porcAcertos = 0.0;
    }

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
