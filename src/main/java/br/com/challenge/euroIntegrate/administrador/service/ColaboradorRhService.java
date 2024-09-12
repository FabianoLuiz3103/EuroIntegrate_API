package br.com.challenge.euroIntegrate.administrador.service;

import br.com.challenge.euroIntegrate.administrador.dto.DadosCadastroColaboradores;
import br.com.challenge.euroIntegrate.administrador.dto.DadosDetalhamentoCadastroColaboradores;
import br.com.challenge.euroIntegrate.administrador.dto.DadosHomeAdmin;
import br.com.challenge.euroIntegrate.administrador.dto.DadosValidarColaboradores;
import br.com.challenge.euroIntegrate.administrador.repository.ColaboradorRhRepository;
import br.com.challenge.euroIntegrate.colaborador.dto.DadosDepartamento;
import br.com.challenge.euroIntegrate.colaborador.model.Colaborador;
import br.com.challenge.euroIntegrate.colaborador.repository.ColaboradorRepository;
import br.com.challenge.euroIntegrate.colaborador.repository.DepartamentoRepository;
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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.time.temporal.ChronoUnit;

@Service
public class ColaboradorRhService {

    @Autowired
    ColaboradorRepository colaboradorRepository;

    @Autowired
    IntegracaoRepository integracaoRepository;

    @Autowired
    ColaboradorRhRepository colaboradorRhRepository;

    @Autowired
    DepartamentoRepository departamentoRepository;


    @Transactional(readOnly = true)
    public DadosHomeAdmin telaHomeAdmin(Long id, String email){
        var nome = colaboradorRepository.findNomeByEmail(email).orElseThrow(
                () -> new RuntimeException("Colaborador não encontrado")
        );
        var totalIntegra = integracaoRepository.count();
        var totalIntegraColabRh = integracaoRepository.countIntegracaoByColaboradorRhId(id);
        var totalTreinados = colaboradorRepository.countByStatusFinalizado(Status.FINALIZADO);
        var maiorDiaMenorDia = integracaoRepository.findMinMaxDates();
        var totalDias = calcularDiasTotal(maiorDiaMenorDia);
        var qtdNaoIniciado = integracaoRepository.countIntegracaoByStatus(Status.NAO_INICIADO);
        var qtdAndamento = integracaoRepository.countIntegracaoByStatus(Status.ANDAMENTO);
        var qtdFinalizado = integracaoRepository.countIntegracaoByStatus(Status.FINALIZADO);

        return new DadosHomeAdmin(
                nome,
                totalIntegra,
                totalIntegraColabRh,
                totalTreinados,
                totalDias,
                qtdNaoIniciado,
                qtdFinalizado,
                qtdAndamento

        );

    }

    private long calcularDiasTotal(List<LocalDate[]> result) {
        if (result.isEmpty()) {
            return 0;
        }
        LocalDate[] dates = result.get(0);
        LocalDate minDate = dates[0];
        LocalDate maxDate = dates[1];

        if (minDate != null && maxDate != null) {
            return ChronoUnit.DAYS.between(minDate, maxDate);
        } else {
            return 0;
        }
    }



    @Transactional
    public List<DadosDetalhamentoCadastroColaboradores> cadastrarColaborador(List<DadosCadastroColaboradores> dados, Long id){
        var rh = colaboradorRhRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Colaborador não encontrado!")
        );
        var colaboradores = dados.stream()
                .map(Colaborador::new)
                .peek(colaborador -> colaborador.setColaboradorRh(rh))
                .collect(Collectors.toList());
        colaboradorRepository.saveAll(colaboradores);

        return colaboradores.stream().map(DadosDetalhamentoCadastroColaboradores::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
 public List<DadosValidarColaboradores> colaboradores(){
        return colaboradorRepository.findAll().stream().map(DadosValidarColaboradores::new).collect(Collectors.toList());
 }

 @Transactional(readOnly = true)
 public List<DadosDepartamento> departamentos(){
        return departamentoRepository.findAll().stream()
                .map(DadosDepartamento::new).collect(Collectors.toList());
 }


    @Transactional
    public DadosDetalhamentoIntegracao cadastrar(DadosCadastroIntegracao dados, Long id) {
        var rh = colaboradorRhRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador RH não encontrado"));
        var numeroColaboradores = colaboradorRepository.countByDepartamentoIdAndStatus(dados.departamento().id());
        var integracao = new Integracao(dados, numeroColaboradores, rh);
        integracaoRepository.save(integracao);
        colaboradorRepository.updateIntegracaoByDepartamentoId(integracao, Status.NAO_INICIADO, dados.departamento().id());

        return new DadosDetalhamentoIntegracao(integracao);
    }


    @Transactional
    //@Scheduled(fixedRate = 60000) // 2 minutos
    @Scheduled(fixedRate = 43200000) // 12 horas
    public void checkDateAndUpdateDatabase() {
        try {
            LocalDateTime now = LocalDateTime.now();
            LocalDate today = now.toLocalDate();

            List<Object[]> datasHoras = integracaoRepository.findDataHoraInicioDataHoraFim();


            for (Object[] dataHora : datasHoras) {
                Long id = (Long) dataHora[0];
                LocalDate dataInicio = (LocalDate) dataHora[1];
                LocalTime horaInicio = (LocalTime) dataHora[2];
                LocalDate dataFim = (LocalDate) dataHora[3];
                LocalTime horaFim = (LocalTime) dataHora[4];
                Status status = (Status) dataHora[5];


                LocalDateTime dataHoraInicio = LocalDateTime.of(dataInicio, horaInicio);
                LocalDateTime dataHoraFim = LocalDateTime.of(dataFim, horaFim);


                if (now.isBefore(dataHoraInicio)) {
                    // Status deve ser "NAO_INICIADO"
                    if (!status.equals(Status.NAO_INICIADO)) {
                        integracaoRepository.atualizarStatusInicio(Status.NAO_INICIADO, id);
                        colaboradorRepository.atualizarStatusInicio(Status.NAO_INICIADO, id);
                    }
                } else if (now.isAfter(dataHoraFim)) {
                    // Status deve ser "FINALIZADO"
                    if (!status.equals(Status.FINALIZADO)) {
                        integracaoRepository.atualizarStatusInicio(Status.FINALIZADO, id);
                        colaboradorRepository.atualizarStatusInicio(Status.FINALIZADO, id);
                    }
                } else {
                    // Status deve ser "ANDAMENTO"
                    if (!status.equals(Status.ANDAMENTO)) {
                        integracaoRepository.atualizarStatusInicio(Status.ANDAMENTO, id);
                        colaboradorRepository.atualizarStatusInicio(Status.ANDAMENTO, id);
                    }
                }
            }

        } catch (DataAccessException ex) {
            throw new RuntimeException("Erro ao acessar o BD");
        } catch (Exception ex) {
            throw new RuntimeException("Erro de execução");
        }
    }








    @Transactional(readOnly = true)
    public List<DadosListagemIntegracao> listar(){
        var integracoes = integracaoRepository.findAll();
        return integracoes.stream().map(DadosListagemIntegracao::new).collect(Collectors.toList());
    }
}
