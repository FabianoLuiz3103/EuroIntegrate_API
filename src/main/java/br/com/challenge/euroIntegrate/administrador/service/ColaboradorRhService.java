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
        var qtdAndamento = integracaoRepository.countIntegracaoByStatus(Status.FINALIZADO);
        var qtdFinalizado = integracaoRepository.countIntegracaoByStatus(Status.FINALIZADO);

        return new DadosHomeAdmin(
                nome,
                totalIntegra,
                totalIntegraColabRh,
                totalTreinados,
                totalDias,
                qtdNaoIniciado,
                qtdAndamento,
                qtdFinalizado
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
    public List<DadosDetalhamentoCadastroColaboradores> cadastrarColaborador(List<DadosCadastroColaboradores> dados){
        var colaboradores = dados.stream().map(Colaborador::new).toList();
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
    @Scheduled(fixedRate = 2400000) // 2 minutos
    public void checkDateAndUpdateDatabase() {
        try {
            LocalDateTime now = LocalDateTime.now();
            LocalDate today = now.toLocalDate();

            // Buscando as datas de início com status "NAO_INICIADO"
            List<Object[]> datasHoras = integracaoRepository.findDataHoraInicioByStatusNaoIniciado();

            // Buscando as datas de fim e status
            List<Object[]> datasHorasFim = integracaoRepository.findDataHoraFimStatus();

            System.out.println("Datas de Início Encontradas: " + datasHoras.size());

            // Atualizando o status baseado na data de início
            for (Object[] dataHora : datasHoras) {
                Long id = (Long) dataHora[0];
                LocalDate dataInicio = (LocalDate) dataHora[1];
                LocalTime horaInicio = (LocalTime) dataHora[2];
                Status status = (Status) dataHora[3];

                // Cria um LocalDateTime com a data de início e a hora de início
                LocalDateTime dataHoraInicio = LocalDateTime.of(dataInicio, horaInicio);

                // Verifica e atualiza o status conforme a data atual e a data de início
                if (today.isEqual(dataInicio)) {
                    // Atualiza para "ANDAMENTO" se a data de início for igual a hoje
                    if (!status.name().equals(Status.ANDAMENTO.name())) {
                        integracaoRepository.atualizarStatusInicio(Status.ANDAMENTO, id);
                        colaboradorRepository.atualizarStatusInicio(Status.ANDAMENTO, id);
                    }
                } else if (today.isBefore(dataInicio)) {
                    // Atualiza para "NAO_INICIADO" se a data de início for maior que hoje
                    if (!status.name().equals(Status.NAO_INICIADO.name())) {
                        integracaoRepository.atualizarStatusInicio(Status.NAO_INICIADO, id);
                        colaboradorRepository.atualizarStatusInicio(Status.NAO_INICIADO, id);
                    }
                } else {
                    // Caso não seja igual ou maior que a data de início, verifica se está dentro do intervalo
                    LocalDateTime dataHoraFimCompleta = LocalDateTime.of(dataInicio.plusDays(1), LocalTime.MAX);

                    if (now.isAfter(dataHoraInicio) && now.isBefore(dataHoraFimCompleta)) {
                        if (!status.name().equals(Status.ANDAMENTO.name())) {
                            integracaoRepository.atualizarStatusInicio(Status.ANDAMENTO, id);
                            colaboradorRepository.atualizarStatusInicio(Status.ANDAMENTO, id);
                        }
                    }
                }
            }

            // Atualizando para "FINALIZADO" se a data de fim for anterior a hoje
            for (Object[] dataHoraFim : datasHorasFim) {
                Long id = (Long) dataHoraFim[0];
                LocalDate dataFim = (LocalDate) dataHoraFim[1];
                LocalTime horaFim = (LocalTime) dataHoraFim[2];
                Status status = (Status) dataHoraFim[3];

                LocalDateTime dataHoraFimCompleta = LocalDateTime.of(dataFim, horaFim);

                if (today.isAfter(dataHoraFimCompleta.toLocalDate())) {
                    // Atualiza para "FINALIZADO"
                    if (!status.name().equals(Status.FINALIZADO.name())) {
                        integracaoRepository.atualizarStatusInicio(Status.FINALIZADO, id);
                        colaboradorRepository.atualizarStatusInicio(Status.FINALIZADO, id);
                    }
                }
            }

        } catch (DataAccessException ex) {
            System.err.println("Erro ao acessar o banco de dados: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Erro durante a execução do método: " + ex.getMessage());
        }
    }



    @Transactional(readOnly = true)
    public List<DadosListagemIntegracao> listar(){
        var integracoes = integracaoRepository.findAll();
        return integracoes.stream().map(DadosListagemIntegracao::new).collect(Collectors.toList());
    }
}
