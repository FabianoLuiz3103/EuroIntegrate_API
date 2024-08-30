package br.com.challenge.euroIntegrate.administrador.service;

import br.com.challenge.euroIntegrate.administrador.repository.ColaboradorRhRepository;
import br.com.challenge.euroIntegrate.colaborador.repository.ColaboradorRepository;
import br.com.challenge.euroIntegrate.integracao.dto.DadosCadastroIntegracao;
import br.com.challenge.euroIntegrate.integracao.dto.DadosDetalhamentoIntegracao;
import br.com.challenge.euroIntegrate.integracao.dto.DadosListagemIntegracao;
import br.com.challenge.euroIntegrate.integracao.model.Integracao;
import br.com.challenge.euroIntegrate.integracao.model.Status;
import br.com.challenge.euroIntegrate.integracao.repository.IntegracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColaboradorRhService {

    @Autowired
    ColaboradorRepository colaboradorRepository;

    @Autowired
    IntegracaoRepository integracaoRepository;

    @Autowired
    ColaboradorRhRepository colaboradorRhRepository;


    @Transactional
    public DadosDetalhamentoIntegracao cadastrar(DadosCadastroIntegracao dados, String email) {
        var rh = colaboradorRhRepository.findByEmailRh(email)
                .orElseThrow(() -> new RuntimeException("Colaborador RH não encontrado"));
        var numeroColaboradores = colaboradorRepository.countByDepartamentoIdAndStatus(dados.departamento().id());
        var integracao = new Integracao(dados, numeroColaboradores, rh);
        integracaoRepository.save(integracao);
        colaboradorRepository.updateIntegracaoByDepartamentoId(integracao, Status.ANDAMENTO, dados.departamento().id());

        return new DadosDetalhamentoIntegracao(integracao);
    }


    @Transactional
    @Scheduled(fixedRate = 12000000) // 2 minutos
    public void checkDateAndUpdateDatabase() {
        try {
            LocalDateTime now = LocalDateTime.now();
            List<Object[]> datasHoras = integracaoRepository.findDataHoraInicioByStatusNaoFez();
            System.out.println(datasHoras.size());
            for (Object[] dataHora : datasHoras) {
                Long id = (Long) dataHora[0];
                LocalDate dataInicio = (LocalDate) dataHora[1];
                System.out.println(dataInicio);
                LocalTime horaInicio = (LocalTime) dataHora[2];
                System.out.println(horaInicio);
                LocalDateTime dataHoraInicio = LocalDateTime.of(dataInicio, horaInicio);

                if (now.isAfter(dataHoraInicio)) {
                    integracaoRepository.atualizarStatusInicio(Status.ANDAMENTO, id);
                    colaboradorRepository.atualizarStatusInicio(Status.ANDAMENTO, id);
                }
            }
        } catch (DataAccessException ex) {
            System.err.println("Erro ao acessar o banco de dados: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Erro durante a execução do método: " + ex.getMessage());
        }
    }



    @Transactional(readOnly = true)
    public List<DadosListagemIntegracao> listar(String email){
        var idRh = colaboradorRhRepository.findRhIdByEmail(email).orElseThrow(
                ()->new RuntimeException("Colaborador de RH não encontrado!"));
        var integracoes = integracaoRepository.findAllByColaboradorRhId(idRh);
        return integracoes.stream().map(DadosListagemIntegracao::new).collect(Collectors.toList());
    }
}
