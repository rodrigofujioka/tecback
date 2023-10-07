package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Serie;
import br.com.fujideia.iesp.tecback.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serie")
public class SerieController {

    @Autowired
    private SerieService service;

    @PostMapping
    public ResponseEntity<Serie> salvar(@RequestBody Serie serie) {
        return ResponseEntity.ok(service.salvar(serie));
    }

    @PutMapping
    public ResponseEntity<Serie> alterar(@RequestBody Serie serie) {
        return ResponseEntity.ok(service.alterar(serie));
    }

    @GetMapping
    public ResponseEntity<List<Serie>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Serie> consultar(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") Integer id) {
        if(service.excluir(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
