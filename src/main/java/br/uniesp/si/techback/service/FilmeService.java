package br.uniesp.si.techback.service;

import br.uniesp.si.techback.exception.EntidadeNaoEncontradaException;
import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.repository.FilmeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public List<Filme> listar() {
        log.info("Buscando todos os filmes cadastrados");
        try {
            List<Filme> filmes = filmeRepository.listarFilmesEmOrdemAlfabetica();
            log.debug("Total de filmes encontrados: {}", filmes.size());
            return filmes;
        } catch (Exception e) {
            log.error("Falha ao buscar filmes: {}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     *
     * @param id o ID do filme.
     * @return o filme encontrado, ou lan a uma exce o {@link EntidadeNaoEncontradaException} se o filme n o existir.
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
     * @param id      o ID do filme a ser atualizado.
     * @param filme   o filme com as informa es atualizadas.
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
     * @param id o ID do filme a ser exclu do.
     * @throws EntidadeNaoEncontradaException se o filme n o existir.
     */
    @Transactional
    public void excluir(Long id) {
        log.info("Solicitada exclusão do filme ID: {}", id);
        
        if (!filmeRepository.existsById(id)) {
            String mensagem = String.format("Falha ao excluir: filme não encontrado com o ID: %d", id);
            log.warn(mensagem);
            throw new EntidadeNaoEncontradaException(mensagem);
        }

        filmeRepository.deleteById(id);
        log.info("Filme ID: {} removido com sucesso", id);
    }
}
