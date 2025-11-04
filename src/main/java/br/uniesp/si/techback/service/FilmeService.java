package br.uniesp.si.techback.service;

import br.uniesp.si.techback.exception.EntidadeNaoEncontradaException;
import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.repository.FilmeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public List<Filme> listar() {
        log.info("Buscando todos os filmes cadastrados");
        try {
            List<Filme> filmes = filmeRepository.findAll();
            log.debug("Total de filmes encontrados: {}", filmes.size());
            return filmes;
        } catch (Exception e) {
            log.error("Falha ao buscar filmes: {}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * @param id o ID do filme.
     * @return o filme encontrado, ou lança uma exceção {@link EntidadeNaoEncontradaException} se o filme não existir.
     */
    public Filme buscarPorId(Long id) {
        log.info("Buscando filme pelo ID: {}", id);
        return filmeRepository.findById(id)
                .map(filme -> {
                    log.debug("Filme encontrado: ID={}, Título={}", filme.getId(), filme.getTitulo());
                    return filme;
                })
                .orElseThrow(() -> {
                    String mensagem = String.format("Filme não encontrado com o ID: %d", id);
                    log.warn(mensagem);
                    return new EntidadeNaoEncontradaException(mensagem);
                });
    }

    /**
     * Atualiza um filme existente.
     *
     * @param id    o ID do filme a ser atualizado.
     * @param filme o filme com as informações atualizadas.
     * @return o filme atualizado.
     */
    @Transactional
    public Filme atualizar(Long id, Filme filme) {
        log.info("Atualizando filme ID: {}", id);
        return filmeRepository.findById(id)
                .map(filmeExistente -> {
                    log.debug("Dados atuais do filme: {}", filmeExistente);
                    log.debug("Novos dados: {}", filme);
                    filme.setId(id);
                    Filme filmeAtualizado = filmeRepository.save(filme);
                    log.info("Filme ID: {} atualizado com sucesso. Novo título: {}",
                            id, filmeAtualizado.getTitulo());
                    return filmeAtualizado;
                })
                .orElseThrow(() -> {
                    String mensagem = String.format("Falha ao atualizar: filme não encontrado com o ID: %d", id);
                    log.warn(mensagem);
                    return new EntidadeNaoEncontradaException(mensagem);
                });
    }

    /**
     * Salva um novo filme.
     *
     * @param filme o filme a ser salvo.
     * @return o filme salvo.
     */
    @Transactional
    public Filme salvar(Filme filme) {
        log.info("Salvando novo filme: {}", filme.getTitulo());
        try {
            Filme filmeSalvo = filmeRepository.save(filme);
            log.info("Filme salvo com sucesso. ID: {}, Título: {}", filmeSalvo.getId(), filmeSalvo.getTitulo());
            return filmeSalvo;
        } catch (Exception e) {
            log.error("Falha ao salvar filme '{}': {}", filme.getTitulo(), e.getMessage(), e);
            throw e;
        }
    }

    /**
     * Exclui um filme existente.
     *
     * @param id o ID do filme a ser excluído.
     */
    @Transactional
    public void excluir(Long id) {
        log.info("Excluindo filme ID: {}", id);
        if (!filmeRepository.existsById(id)) {
            String mensagem = String.format("Falha ao excluir: filme não encontrado com o ID: %d", id);
            log.warn(mensagem);
            throw new EntidadeNaoEncontradaException(mensagem);
        }
        try {
            filmeRepository.deleteById(id);
            log.info("Filme ID: {} excluído com sucesso", id);
        } catch (Exception e) {
            log.error("Erro ao excluir filme ID {}: {}", id, e.getMessage(), e);
            throw e;
        }
    }

    /**
     * Busca filmes por título (case-insensitive).
     *
     * @param titulo o título ou parte do título a ser buscado
     * @return lista de filmes encontrados
     */
    public List<Filme> buscarPorTitulo(String titulo) {
        log.info("Buscando filmes com título contendo: {}", titulo);
        List<Filme> filmes = filmeRepository.findByTituloContainingIgnoreCase(titulo);
        log.debug("Encontrados {} filmes com título contendo '{}'", filmes.size(), titulo);
        return filmes;
    }

    /**
     * Busca filmes por gênero.
     *
     * @param genero o gênero dos filmes a serem buscados
     * @return lista de filmes encontrados
     */
    public List<Filme> buscarPorGenero(String genero) {
        log.info("Buscando filmes do gênero: {}", genero);
        List<Filme> filmes = filmeRepository.findByGenero(genero);
        log.debug("Encontrados {} filmes do gênero '{}'", filmes.size(), genero);
        return filmes;
    }

    /**
     * Busca filmes por classificação indicativa.
     *
     * @param classificacao a classificação indicativa dos filmes a serem buscados
     * @return lista de filmes encontrados
     */
    public List<Filme> buscarPorClassificacao(String classificacao) {
        log.info("Buscando filmes com classificação: {}", classificacao);
        List<Filme> filmes = filmeRepository.findByClassificacaoIndicativa(classificacao);
        log.debug("Encontrados {} filmes com classificação '{}'", filmes.size(), classificacao);
        return filmes;
    }


    /**
     * Busca filmes com duração mínima informada.
     *
     * @param duracaoMinima a duração mínima do filme a ser buscado.
     * @return lista de filmes encontrados.
     */
    public List<Filme> buscarPorDuracaoMinima(int duracaoMinima) {
        log.info("Buscando filmes com duração mínima de {} minutos", duracaoMinima);
        List<Filme> filmes = filmeRepository.buscarPorDuracaoMinima(duracaoMinima);
        log.debug("Encontrados {} filmes com duração mínima de {} minutos", filmes.size(), duracaoMinima);
        return filmes;
    }

    /**
     * Busca filmes lançados entre as datas informadas.
     *
     * @param dataInicio a data de início do período de lançamento.
     * @param dataFim    a data de fim do período de lançamento.
     * @return lista de filmes encontrados.
     */
    public List<Filme> buscarPorIntervaloDataLancamento(String dataInicio, String dataFim) {
        log.info("Buscando filmes lançados entre {} e {}", dataInicio, dataFim);
        List<Filme> filmes = filmeRepository.buscarPorIntervaloDataLancamento(
                LocalDate.parse(dataInicio),
                LocalDate.parse(dataFim)
        );
        log.debug("Encontrados {} filmes no período especificado", filmes.size());
        return filmes;
    }

    /**
     * Busca filmes com a palavra-chave informada na sinopse.
     *
     * @param palavraChave a palavra-chave a ser buscado na sinopse.
     * @return lista de filmes encontrados.
     */
    public List<Filme> buscarPorPalavraChaveNaSinopse(String palavraChave) {
        log.info("Buscando filmes com a palavra-chave '{}' na sinopse", palavraChave);
        List<Filme> filmes = filmeRepository.buscarPorPalavraChaveNaSinopse(palavraChave);
        log.debug("Encontrados {} filmes com a palavra-chave '{}' na sinopse", filmes.size(), palavraChave);
        return filmes;
    }

    /**
     * Conta filmes por gênero.
     *
     * @return lista de objetos contendo o gênero e a quantidade de filmes.
     */
    public List<Object[]> contarFilmesPorGenero() {
        log.info("Contando filmes por gênero");
        List<Object[]> contagem = filmeRepository.contarFilmesPorGenero();
        log.debug("Encontrados {} gêneros diferentes", contagem.size());
        return contagem;
    }

    /**
     * Busca todos os filmes ordenados por data de lançamento (mais recentes primeiro).
     *
     * @return lista de filmes encontrados.
     */
    public List<Filme> buscarTodosOrdenadosPorDataLancamento() {
        log.info("Buscando todos os filmes ordenados por data de lançamento (mais recentes primeiro)");
        List<Filme> filmes = filmeRepository.buscarTodosOrdenadosPorDataLancamento();
        log.debug("Encontrados {} filmes", filmes.size());
        return filmes;
    }
}
