package br.com.challenge.euroIntegrate.colaborador.service;

import br.com.challenge.euroIntegrate.colaborador.dto.DadosDetalhamentoResposta;
import br.com.challenge.euroIntegrate.colaborador.dto.DadosResponsePerguntas;
import br.com.challenge.euroIntegrate.colaborador.dto.DadosResposta;
import br.com.challenge.euroIntegrate.colaborador.model.Resposta;
import br.com.challenge.euroIntegrate.colaborador.model.RespostaId;
import br.com.challenge.euroIntegrate.colaborador.repository.ColaboradorRepository;
import br.com.challenge.euroIntegrate.colaborador.repository.PerguntaRepository;
import br.com.challenge.euroIntegrate.colaborador.repository.RespostaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;


    @Transactional
    public List<DadosDetalhamentoResposta> save(DadosResponsePerguntas dadosResposta) {
        List<Resposta> respostas = new ArrayList<>();
        for (DadosResposta dr : dadosResposta.dadosRespostas()) {
            Resposta resposta = new Resposta(dr);
            respostas.add(resposta);
        }

        respostaRepository.saveAll(respostas);

        return respostas.stream()
                .map(DadosDetalhamentoResposta::new)
                .collect(Collectors.toList());
    }



    @Transactional(readOnly = true)
    public List<DadosDetalhamentoResposta> findAll(Long id){
        return  respostaRepository.findAllByColaboradorId(id).stream()
                .map(DadosDetalhamentoResposta::new).collect(Collectors.toList());
    }
}
