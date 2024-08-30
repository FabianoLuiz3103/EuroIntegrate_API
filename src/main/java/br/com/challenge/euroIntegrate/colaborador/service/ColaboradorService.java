package br.com.challenge.euroIntegrate.colaborador.service;

import br.com.challenge.euroIntegrate.colaborador.dto.*;
import br.com.challenge.euroIntegrate.colaborador.model.Normas;
import br.com.challenge.euroIntegrate.colaborador.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ColaboradorService {

    @Autowired
    ColaboradorRepository colaboradorRepository;

    @Autowired
    VideosRepository videosRepository;

    @Autowired
    NormasRepository normasRepository;

    @Autowired
    RespostaService respostaService;

    @Transactional(readOnly = true)
    public idColaboradorDTO getIdColaborador(String email){
        var id = colaboradorRepository.findIdByEmail(email).orElseThrow(
                () -> new RuntimeException("Colaborador não encontrado!")
        );
        return new idColaboradorDTO(id);
    }

    @Transactional(readOnly = true)
    public DadosHomeColaborador dadosHomeColaborador(Long id) {
        return new DadosHomeColaborador(colaboradorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Colaborador não encontrado!")));
    }

    @Transactional(readOnly = true)
    public DadosDetalhamentoColaborador dadosColaborador(Long id) {
        return new DadosDetalhamentoColaborador(colaboradorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Colaborador não encontrado!")));
    }

    @Transactional
    public DadosDetalhamentoColaborador atualizacaoAvatar(DadosAtualizacaoAvatar dados, Long id) {
        var colaborador = colaboradorRepository.getReferenceById(id);
        colaborador.atualizarAvatar(dados);
        return new DadosDetalhamentoColaborador(colaborador);
    }

    @Transactional
    public DadosDetalhamentoColaborador atualizarDadosColaborador(DadosResponseVideos dados, Long id){
        var colaborador = colaboradorRepository.getReferenceById(id);
        colaborador.atualizarDados(dados);
        return new DadosDetalhamentoColaborador(colaborador);
    }

    @Transactional(readOnly = true)
    public DadosVideoSeq dadosVideosSeq(Long id){
        InfosColaboradorTelaVideos colaboradorInfo = colaboradorRepository.findColaboradorInfoById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado!"));

        Long idColaborador = colaboradorInfo.id();
        Double porcProgresso = colaboradorInfo.porcProgresso();
        Integer pontuacao = colaboradorInfo.pontuacao();
        Integer qtdRespondidas = colaboradorInfo.qtdRespondidas();
        Integer qtdCertas = colaboradorInfo.qtdCertas();
        return new DadosVideoSeq(idColaborador, porcProgresso, pontuacao, qtdRespondidas, qtdCertas, respostaService.findAll(idColaborador) );
    }

    @Transactional(readOnly = true)
    public List<DadosVideos> carregarVideosComPerguntas(Long id) {
        Long idDept = colaboradorRepository.findDepartamentoIdById(id).orElseThrow(
                ()-> new RuntimeException("Colaborador não encontrado!"));

        var videos = videosRepository.findAllByDepartamentoIdWithPerguntasAndOpcoes(idDept);
        return videos.stream()
                .map(video -> {
                    var perguntas = video.getPerguntas().stream()
                            .map(pergunta -> {
                                var opcoes = pergunta.getOpcoes().stream()
                                        .map(DadosOpcoes::new)
                                        .toList();
                                return new DadosPerguntas(pergunta, opcoes);
                            })
                            .toList();
                    return new DadosVideos(video, perguntas);
                })
                .toList();
    }

    @Transactional(readOnly = true)
    public List<DadosNormas> carregarNormasComPerguntasDept(Long id) {
        Long idDept = colaboradorRepository.findDepartamentoIdById(id).orElseThrow(
                ()-> new RuntimeException("Colaborador não encontrado!"));
        var normas = normasRepository.findAllByDepartamentoIdWithPerguntasAndOpcoes(idDept);
        return perguntasNormas(normas);
    }

    @Transactional(readOnly = true)
    public List<DadosNormas> carregarNormasComPerguntasGeral() {
        var normas = normasRepository.findAllByDepartamentoIdIsNull();
        return perguntasNormas(normas);
    }

    private List<DadosNormas> perguntasNormas(List<Normas> normas){
        return normas.stream()
                .map(
                        norma -> {
                            var perguntas = norma.getPerguntas().stream().map(
                                    pergunta -> {
                                        var opcoes = pergunta.getOpcoes().stream()
                                                .map(DadosOpcoes::new)
                                                .toList();
                                        return new DadosPerguntas(pergunta, opcoes);
                                    })
                                    .toList();
                            return new DadosNormas(norma, perguntas);
                        }
                ).toList();
    }







}
