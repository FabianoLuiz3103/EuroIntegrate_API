package br.com.challenge.euroIntegrate.ranking.service;

import br.com.challenge.euroIntegrate.colaborador.repository.ColaboradorRepository;
import br.com.challenge.euroIntegrate.colaborador.repository.DepartamentoRepository;
import br.com.challenge.euroIntegrate.integracao.repository.IntegracaoRepository;
import br.com.challenge.euroIntegrate.ranking.dto.DadosRanking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RankingService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Transactional(readOnly = true)
    public List<DadosRanking> findRanking(){
        return colaboradorRepository.findDadosRanking();
    }
}
