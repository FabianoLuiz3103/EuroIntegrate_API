package br.com.challenge.euroIntegrate.administrador.service;

import br.com.challenge.euroIntegrate.administrador.dto.*;
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

import java.time.*;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

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




    @Transactional(readOnly = true)
    public List<DadosDash> dash() {
        LocalDate now = LocalDate.now();

        // Obter dados de nascimento e ano da integração
        Map<Integer, List<Integer>> idadesPorAnoIntegracao = colaboradorRepository.findAllDataNascimentoAndYearIntegracao().stream()
                .collect(Collectors.groupingBy(
                        result -> (Integer) result[1],  // Ano da integração
                        Collectors.mapping(result -> {
                            // Converter LocalDate para calcular a idade
                            LocalDate nascimento = (LocalDate) result[0];
                            // Calcular a idade
                            return Period.between(nascimento, now).getYears();
                        }, Collectors.toList())
                ));

        // Obter dados de quantidade respondida e certa por ano da integração
        Map<Integer, List<Integer>> respondidasPorAnoIntegracao = colaboradorRepository.findAllQtdRespondidasAndQtdCertasAndYearIntegracao().stream()
                .collect(Collectors.groupingBy(
                        result -> (Integer) result[2],  // Ano da integração
                        Collectors.mapping(result -> (Integer) result[0], Collectors.toList())
                ));

        Map<Integer, List<Integer>> certasPorAnoIntegracao = colaboradorRepository.findAllQtdRespondidasAndQtdCertasAndYearIntegracao().stream()
                .collect(Collectors.groupingBy(
                        result -> (Integer) result[2],  // Ano da integração
                        Collectors.mapping(result -> (Integer) result[1], Collectors.toList())
                ));

        // Obter dados de média de progresso por mês e ano
        Map<Integer, Map<Integer, Double>> mediaProgressoPorAnoMes = integracaoRepository.findAvgProgressMonth().stream()
                .collect(Collectors.groupingBy(
                        result -> (Integer) result[0],  // Ano da integração
                        Collectors.toMap(
                                result -> (Integer) result[1],  // Mês
                                result -> (Double) result[2],  // Média de progresso
                                (existing, replacement) -> replacement  // Em caso de chaves duplicadas, manter o valor mais recente
                        )
                ));

        // Obter dados de média de acertos por mês e ano
        Map<Integer, Map<Integer, Double>> mediaAcertosPorAnoMes = integracaoRepository.findAvgAcertosMonth().stream()
                .collect(Collectors.groupingBy(
                        result -> (Integer) result[0],  // Ano da integração
                        Collectors.toMap(
                                result -> (Integer) result[1],  // Mês
                                result -> (Double) result[2],  // Média de acertos
                                (existing, replacement) -> replacement  // Em caso de chaves duplicadas, manter o valor mais recente
                        )
                ));

        // Obter dados de quantidade de processos criados por mês e ano
        Map<Integer, Map<Integer, Long>> quantidadeProcessosPorAnoMes = integracaoRepository.findQuantidadePorMes().stream()
                .collect(Collectors.groupingBy(
                        result -> (Integer) result[0],  // Ano da integração
                        Collectors.toMap(
                                result -> (Integer) result[1],  // Mês
                                result -> (Long) result[2],  // Quantidade de processos
                                (existing, replacement) -> replacement  // Em caso de chaves duplicadas, manter o valor mais recente
                        )
                ));


        var departamentos = departamentoRepository.findAll().stream()
                .map(DadosDepartamento::new).toList();
        // Criar uma lista de DadosDash para cada ano com os dados consolidados
        return idadesPorAnoIntegracao.entrySet().stream()
                .map(entry -> new DadosDash(
                        List.of(entry.getKey()),
                        entry.getValue(),  // Lista de idades para o ano
                        respondidasPorAnoIntegracao.getOrDefault(entry.getKey(), List.of()),  // Lista de respondidas para o ano
                        certasPorAnoIntegracao.getOrDefault(entry.getKey(), List.of()),  // Lista de certas para o ano
                        createFullMonthMap(mediaProgressoPorAnoMes.getOrDefault(entry.getKey(), Map.of())),  // Mapa de média de progresso por mês
                        createFullMonthMap(mediaAcertosPorAnoMes.getOrDefault(entry.getKey(), Map.of())),  // Mapa de média de acertos por mês
                        createFullMonthMapQuantidadeProcessos(quantidadeProcessosPorAnoMes.getOrDefault(entry.getKey(), Map.of()))
                ))
                .collect(Collectors.toList());
    }

    // Método auxiliar para criar um mapa com todos os meses e preencher com 0.0 se não houver dados
    private Map<String, Double> createFullMonthMap(Map<Integer, Double> progressoPorMes) {
        return IntStream.rangeClosed(1, 12)
                .boxed()
                .collect(Collectors.toMap(
                        this::getNomeMes,  // Nome do mês
                        mes -> progressoPorMes.getOrDefault(mes, 0.0)  // Preenche com 0.0 se o mês não estiver presente
                ));
    }

    // Método auxiliar para criar um mapa com todos os meses e preencher com 0 se não houver dados
    private Map<String, Long> createFullMonthMapQuantidadeProcessos(Map<Integer, Long> processosPorMes) {
        return IntStream.rangeClosed(1, 12)
                .boxed()
                .collect(Collectors.toMap(
                        this::getNomeMes,  // Nome do mês
                        mes -> processosPorMes.getOrDefault(mes, 0L)  // Preenche com 0 se o mês não estiver presente
                ));
    }


    // Método auxiliar para converter o número do mês em nome
    private String getNomeMes(int mes) {
        return java.time.Month.of(mes).name();
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
