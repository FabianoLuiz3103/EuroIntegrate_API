package br.com.challenge.euroIntegrate.administrador.controller;

import br.com.challenge.euroIntegrate.administrador.dto.DadosCadastroColaboradores;
import br.com.challenge.euroIntegrate.administrador.dto.DadosDetalhamentoCadastroColaboradores;
import br.com.challenge.euroIntegrate.administrador.dto.DadosHomeAdmin;
import br.com.challenge.euroIntegrate.administrador.dto.DadosValidarColaboradores;
import br.com.challenge.euroIntegrate.administrador.service.ColaboradorRhService;
import br.com.challenge.euroIntegrate.colaborador.dto.DadosDepartamento;
import br.com.challenge.euroIntegrate.integracao.dto.DadosCadastroIntegracao;
import br.com.challenge.euroIntegrate.integracao.dto.DadosDetalhamentoIntegracao;
import br.com.challenge.euroIntegrate.integracao.dto.DadosListagemIntegracao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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


    @PostMapping("cadastrar-colaboradores/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<DadosDetalhamentoCadastroColaboradores>> cadastrarColaboradores(
            @PathVariable Long id,
         @RequestBody @Valid List<DadosCadastroColaboradores> dados, UriComponentsBuilder uriBuilder){
        var colaboradores = colaboradorRhService.cadastrarColaborador(dados, id);
        URI uri = uriBuilder.path("/colaboradores").build().toUri();
        return ResponseEntity.created(uri).body(colaboradores);
    }

    @GetMapping("listar-colaboradores")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<DadosValidarColaboradores>> colaboradores(){
        var colaboradores = colaboradorRhService.colaboradores();
        return ResponseEntity.ok(colaboradores);
    }

    @GetMapping("listar-departamentos")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<DadosDepartamento>> departamentos(){
        var departamentos = colaboradorRhService.departamentos();
        return ResponseEntity.ok(departamentos);
    }

    @PostMapping("/cadastrar-integracao/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DadosDetalhamentoIntegracao> cadastrarIntegracao(
            @PathVariable Long id,
                                                                @RequestBody
                                                                @Valid
                                                                DadosCadastroIntegracao dados,
                                                                UriComponentsBuilder uriBuilder){
        var dadosD = colaboradorRhService.cadastrar(dados, id);
        var uri = uriBuilder.path("/rh/integracao/{id}").buildAndExpand(dadosD.id()).toUri();
        return ResponseEntity.created(uri).body(dadosD);

    }

    @GetMapping("/listar-integracoes")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<DadosListagemIntegracao>> listarIntegracoes(){
        return new ResponseEntity<>(colaboradorRhService.listar(), HttpStatus.OK);
    }


    @GetMapping("/tela-home-admin/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DadosHomeAdmin> homeAdmin(@PathVariable Long id, Authentication authentication){
        var email = authentication.getName();
        var dados = colaboradorRhService.telaHomeAdmin(id, email);
        return ResponseEntity.ok(dados);
    }


}
