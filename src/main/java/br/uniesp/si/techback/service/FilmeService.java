package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.repository.FilmeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class FilmeService {


    private final FilmeRepository repository;

    public List<Filme> listarTodos() {
        log.info("Listando todos os filmes");
        return repository.findAll();
    }

    public Optional<Filme> buscarPorId(Integer id) {
        log.info("Busca de filmes por id {} ", id);
        return repository.findById(id);
    }

    public Filme salvar(Filme filme) {
        return repository.save(filme);
    }

    public Filme atualizar(Integer id, Filme filmeAtualizado) {
        return repository.findById(id)
                .map(filme -> {
                    filme.setTitulo(filmeAtualizado.getTitulo());
                    filme.setAutor(filmeAtualizado.getAutor());
                    return repository.save(filme);
                }).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
