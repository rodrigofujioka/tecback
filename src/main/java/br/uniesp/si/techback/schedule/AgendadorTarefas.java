package br.uniesp.si.techback.schedule;

import br.uniesp.si.techback.cache.ServicoCacheExemplo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * Exemplo de classe que demonstra o uso de agendamento com Spring Scheduler.
 * Esta classe contém métodos que são executados em intervalos regulares.
 */
@Component
@EnableScheduling
public class AgendadorTarefas {

    private static final Logger LOGGER = LoggerFactory.getLogger(AgendadorTarefas.class);
    private final ServicoCacheExemplo servicoCacheExemplo;

    public AgendadorTarefas(ServicoCacheExemplo servicoCacheExemplo) {
        this.servicoCacheExemplo = servicoCacheExemplo;
    }

    // 1. Tarefa executada a cada 30 segundos durante o horário comercial (9h às 18h)
    @Scheduled(cron = "0/30 * 9-18 * * MON-FRI")
    public void tarefaHorarioComercial() {
        LOGGER.info("Tarefa do horário comercial executada: {}", LocalTime.now());
    }

    // 2. Tarefa executada todo dia à meia-noite
    @Scheduled(cron = "0 0 0 * * *")
    public void tarefaDiaria() {
        LOGGER.info("Tarefa diária executada em: {}", LocalDateTime.now());
        // Aqui poderia ir uma rotina de backup, limpeza de logs antigos, etc.
    }

    // 3. Tarefa executada a cada hora, mas apenas se a execução anterior já tiver terminado
    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.HOURS)
    public void tarefaComDelayFixo() {
        LOGGER.info("Iniciando tarefa com delay fixo: {}", LocalTime.now());
        try {
            // Simula um processamento demorado
            Thread.sleep(5000);
            LOGGER.info("Tarefa com delay fixo concluída");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // 4. Tarefa executada a cada 5 minutos, independente do término da anterior
    @Scheduled(fixedRate = 5, timeUnit = TimeUnit.MINUTES)
    public void tarefaComTaxaFixa() {
        LOGGER.info("Tarefa com taxa fixa executada: {}", LocalTime.now());
    }

    // 5. Tarefa com delay inicial de 1 minuto e depois a cada 2 horas
    @Scheduled(initialDelay = 1, fixedRate = 2, timeUnit = TimeUnit.HOURS)
    public void tarefaComDelayInicial() {
        LOGGER.info("Tarefa com delay inicial executada: {}", LocalTime.now());
    }

    // 6. Limpeza de cache programada (executa às 2h da manhã todo dia)
    @Scheduled(cron = "0 0 2 * * *")
    public void limparCacheAgendado() {
        LOGGER.info("Iniciando limpeza de cache agendada");
        servicoCacheExemplo.limparCache();
        LOGGER.info("Limpeza de cache concluída");
    }

    // 7. Tarefa executada apenas nos primeiros 10 segundos de cada minuto
    @Scheduled(cron = "0-9 * * * * *")
    public void tarefaComJanelaDeTempo() {
        LOGGER.info("Tarefa executada dentro da janela de tempo: {}", LocalTime.now());
    }
}
