package br.uniesp.si.techback.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.uniesp.si.techback.model.Genero;
import br.uniesp.si.techback.service.GeneroService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/generos")
@RequiredArgsConstructor
public class GeneroController {

    private final GeneroService service;

    @PostMapping
    public Genero salvar(@RequestBody Genero genero) {
        return service.salvar(genero);
    }

    @GetMapping
    public List<Genero> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public Genero atualizar(@PathVariable Long id, @RequestBody Genero genero) {
        return service.atualizar(id, genero);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
