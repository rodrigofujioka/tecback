package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.service.FilmeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/filmes")
public class FilmeController {


    private final FilmeService service;

    @GetMapping
    @Cacheable("listar_filmes_all")
    public List<Filme> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Filme criar(@RequestBody Filme filme) {
        return service.salvar(filme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizar(@PathVariable Integer id, @RequestBody Filme filme) {
        log.info("Atualizando filme {}", filme);
        try {
            Filme atualizado = service.atualizar(id, filme);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            log.error("Erro ao atualizar filme {} erro {} ", filme, e);
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
