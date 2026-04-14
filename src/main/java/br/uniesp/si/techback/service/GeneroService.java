package br.uniesp.si.techback.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.uniesp.si.techback.model.Genero;
import br.uniesp.si.techback.repository.GeneroRepository;

@Service
public class GeneroService {

    private final GeneroRepository repository;

    public GeneroService(GeneroRepository repository) {
        this.repository = repository;
    }

    public Genero salvar(Genero genero) {
        genero.setId(null);
        return repository.save(genero);
    }

    public List<Genero> listarTodos() {
        return repository.findAll();
    }

    public Genero buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Genero inexistente"));
    }

    public Genero atualizar(Long id, Genero genero) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Genero inexistente");
        }
        genero.setId(id);
        return repository.save(genero);
    }

    public void excluir(Long id) {
        Genero genero = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Genero inexistente"));
        repository.delete(genero);
    }
}
