package br.com.challenge.euroIntegrate.administrador.controller;

import br.com.challenge.euroIntegrate.administrador.dto.DadosCadastroColaboradores;
import br.com.challenge.euroIntegrate.administrador.dto.DadosDetalhamentoCadastroColaboradores;
import br.com.challenge.euroIntegrate.administrador.dto.DadosValidarColaboradores;
import br.com.challenge.euroIntegrate.administrador.service.ColaboradorRhService;
import br.com.challenge.euroIntegrate.integracao.dto.DadosCadastroIntegracao;
import br.com.challenge.euroIntegrate.integracao.dto.DadosDetalhamentoIntegracao;
import br.com.challenge.euroIntegrate.integracao.dto.DadosListagemIntegracao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rh")
public class ColaboradorRhController {

    @Autowired
    ColaboradorRhService colaboradorRhService;


    @PostMapping("cadastrar-colaboradores")
    public ResponseEntity<List<DadosDetalhamentoCadastroColaboradores>> cadastrarColaboradores(
         @RequestBody @Valid List<DadosCadastroColaboradores> dados, UriComponentsBuilder uriBuilder){
        var colaboradores = colaboradorRhService.cadastrarColaborador(dados);
        URI uri = uriBuilder.path("/colaboradores").build().toUri();
        return ResponseEntity.created(uri).body(colaboradores);
    }

    @GetMapping("listar-colaboradores")
    public ResponseEntity<List<DadosValidarColaboradores>> findAll(){
        var colaboradores = colaboradorRhService.colaboradores();
        return ResponseEntity.ok(colaboradores);
    }

    @PostMapping("/cadastrar-integracao")
    public ResponseEntity<DadosDetalhamentoIntegracao> cadastrarIntegracao(
                                                                @RequestBody
                                                                @Valid
                                                                DadosCadastroIntegracao dados,
                                                                UriComponentsBuilder uriBuilder,
                                                                Authentication authentication){
        String email = authentication.getName();
        var dadosD = colaboradorRhService.cadastrar(dados, email);
        var uri = uriBuilder.path("/rh/integracao/{id}").buildAndExpand(dadosD.id()).toUri();
        return ResponseEntity.created(uri).body(dadosD);

    }

    @GetMapping("/listar-integracoes")
    public ResponseEntity<List<DadosListagemIntegracao>> listarIntegracoes( Authentication authentication){
        String email = authentication.getName();
        return new ResponseEntity<>(colaboradorRhService.listar(email), HttpStatus.OK);
    }


}
