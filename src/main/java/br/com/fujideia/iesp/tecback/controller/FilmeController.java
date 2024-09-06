package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.service.FilmeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
public class FilmeController {

    private final FilmeService filmeService;

    @GetMapping
    public ResponseEntity<List<Filme>> listarTodos() {
        List<Filme> filmes = filmeService.listarTodos();
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable Long id) {
        Optional<Filme> filme = filmeService.buscarPorId(id);
        if (filme.isPresent()) {
            return ResponseEntity.ok(filme.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Filme> criarFilme(@RequestBody Filme filme) {
        Filme filmeCriado = filmeService.criarFilme(filme);
        return ResponseEntity.ok(filmeCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable Long id, @RequestBody Filme filmeDetalhes) {
        Optional<Filme> filmeAtualizado = filmeService.atualizarFilme(id, filmeDetalhes);
        if (filmeAtualizado.isPresent()) {
            return ResponseEntity.ok(filmeAtualizado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilme(@PathVariable Long id) {
        boolean deletado = filmeService.deletarFilme(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
