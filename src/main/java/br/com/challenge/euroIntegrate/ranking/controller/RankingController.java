package br.com.challenge.euroIntegrate.ranking.controller;

import br.com.challenge.euroIntegrate.ranking.dto.DadosRanking;
import br.com.challenge.euroIntegrate.ranking.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    @Autowired
    private RankingService rankingService;

    @GetMapping
    public ResponseEntity<List<DadosRanking>> findRanking(){
        var ranking = rankingService.findRanking();
        return ResponseEntity.ok(ranking);
    }
}
