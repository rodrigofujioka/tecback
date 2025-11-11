package br.uniesp.si.techback.service;

import br.uniesp.si.techback.exception.EntidadeNaoEncontradaException;
import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.repository.FilmeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public List<Filme> listar() {
        return filmeRepository.findAll();
    }

    /**
     * Busca um filme por ID.
     *
     * @param id o ID do filme.
     * @return o filme encontrado, ou lan a uma exce o {@link EntidadeNaoEncontradaException} se o filme n o existir.
     */
    public Filme buscarPorId(Long id) {
        return filmeRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Filme n o encontrado com o ID: " + id));
    }

    /**
     * Salva um novo filme.
     *
     * @param filme o filme a ser salvo.
     * @return o filme salvo.
     */
    @Transactional
    public Filme salvar(Filme filme) {
        return filmeRepository.save(filme);
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
        // Verifica se o filme existe
        if (!filmeRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Filme n o encontrado com o ID: " + id);
        }

        // Atualiza o ID do filme para o valor recebido
        filme.setId(id);

        // Salva o filme atualizado
        return filmeRepository.save(filme);
    }

    /**
     * Exclui um filme existente.
     *
     * @param id o ID do filme a ser exclu do.
     * @throws EntidadeNaoEncontradaException se o filme n o existir.
     */
    @Transactional
    public void excluir(Long id) {
        // Verifica se o filme existe
        if (!filmeRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Filme n o encontrado com o ID: " + id);
        }

        // Exclui o filme
        filmeRepository.deleteById(id);
    }
}
