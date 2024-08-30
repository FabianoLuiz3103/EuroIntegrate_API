package br.com.challenge.euroIntegrate.autenticacao.controller;

import br.com.challenge.euroIntegrate.autenticacao.dto.LoginDTO;
import br.com.challenge.euroIntegrate.autenticacao.dto.TokenDTO;
import br.com.challenge.euroIntegrate.autenticacao.dto.TokenDatails;
import br.com.challenge.euroIntegrate.autenticacao.service.AutenticacaoService;
import br.com.challenge.euroIntegrate.colaborador.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private ColaboradorService colaboradorService;

    @PostMapping("/login")
    public ResponseEntity<TokenDatails> autenticarUsuario(@RequestBody LoginDTO login){
        var token = autenticacaoService.autenticarUsuario(login);
        var idColaborador = colaboradorService.getIdColaborador(login.email());
        return new ResponseEntity<>(new TokenDatails(token, idColaborador), HttpStatus.OK);
    }
}
