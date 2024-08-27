package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping
    public List<Filme> listarTodos() {
        return filmeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable Long id) {
        Optional<Filme> filme = filmeRepository.findById(id);
        if (filme.isPresent()) {
            return ResponseEntity.ok(filme.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Filme criarFilme(@RequestBody Filme filme) {
        return filmeRepository.save(filme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable Long id, @RequestBody Filme filmeDetalhes) {
        Optional<Filme> filmeOptional = filmeRepository.findById(id);
        if (filmeOptional.isPresent()) {
            Filme filme = filmeOptional.get();
            filme.setTitulo(filmeDetalhes.getTitulo());
            filme.setAnoLancamento(filmeDetalhes.getAnoLancamento());
            filme.setDiretor(filmeDetalhes.getDiretor());
            filme.setAtores(filmeDetalhes.getAtores());
            filme.setGeneros(filmeDetalhes.getGeneros());
            Filme filmeAtualizado = filmeRepository.save(filme);
            return ResponseEntity.ok(filmeAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilme(@PathVariable Long id) {
        if (filmeRepository.existsById(id)) {
            filmeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
