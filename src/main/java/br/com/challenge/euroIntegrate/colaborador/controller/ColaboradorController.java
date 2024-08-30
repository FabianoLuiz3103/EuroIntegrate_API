package br.com.challenge.euroIntegrate.colaborador.controller;

import br.com.challenge.euroIntegrate.colaborador.dto.*;
import br.com.challenge.euroIntegrate.colaborador.model.Normas;
import br.com.challenge.euroIntegrate.colaborador.service.ColaboradorService;
import br.com.challenge.euroIntegrate.colaborador.service.RespostaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private RespostaService respostaService;

    @GetMapping("/home/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DadosHomeColaborador> telaHome(@PathVariable Long id) {
        return new ResponseEntity<>(colaboradorService.dadosHomeColaborador(id), HttpStatus.OK);
    }
    @GetMapping("/perfil/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DadosDetalhamentoColaborador> telaPerfil(@PathVariable Long id){
        return new ResponseEntity<>(colaboradorService.dadosColaborador(id), HttpStatus.OK);
    }

    @PatchMapping("/avatar/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DadosDetalhamentoColaborador> atualizarAvatar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoAvatar dados){
        var colaborador = colaboradorService.atualizacaoAvatar(dados, id);
        return new ResponseEntity<>(colaborador, HttpStatus.OK);
    }

    @GetMapping("/videos/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<DadosVideos>> telaVideos(@PathVariable Long id) {
        var videosComPerguntas = colaboradorService.carregarVideosComPerguntas(id);
        return new ResponseEntity<>(videosComPerguntas, HttpStatus.OK);

    }
    @GetMapping("/videos-seq/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DadosVideoSeq> telaVideosSeq(@PathVariable Long id) {
        var dadosSeq = colaboradorService.dadosVideosSeq(id);
        return new ResponseEntity<>(dadosSeq, HttpStatus.OK);

    }

    @GetMapping("/normas-departamento/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<DadosNormas>> telaNormasDepartamento(@PathVariable Long id){
        var normasComPerguntas = colaboradorService.carregarNormasComPerguntasDept(id);
        return new ResponseEntity<>(normasComPerguntas, HttpStatus.OK);
    }

    @GetMapping("/normas-gerais")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<DadosNormas>> telaNormasGerais(){
        var normasComPerguntas = colaboradorService.carregarNormasComPerguntasGeral();
        return new ResponseEntity<>(normasComPerguntas, HttpStatus.OK);
    }

    @PostMapping("/resposta")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<DadosDetalhamentoResposta>> saveResposta(@RequestBody @Valid DadosResponsePerguntas dadosResposta){
        var resposta = respostaService.save(dadosResposta);
        return new ResponseEntity<>(resposta, HttpStatus.CREATED);
    }

    @PatchMapping("/atualizar/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DadosDetalhamentoColaborador> atualizarDados(@PathVariable Long id, @RequestBody @Valid DadosResponseVideos dados){
        var colaborador = colaboradorService.atualizarDadosColaborador(dados, id);
        return new ResponseEntity<>(colaborador, HttpStatus.OK);
    }

}
