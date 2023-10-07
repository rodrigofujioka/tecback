package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Episodio;
import br.com.fujideia.iesp.tecback.service.EpisodioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/episodio")
public class EpisodioController {

    @Autowired
    private EpisodioService service;

    @PostMapping
    public ResponseEntity<Episodio> salvar(@RequestBody Episodio episodio) {
        return ResponseEntity.ok(service.salvar(episodio));
    }

    @PutMapping
    public ResponseEntity<Episodio> alterar(@RequestBody Episodio episodio) {
        return ResponseEntity.ok(service.alterar(episodio));
    }

    @GetMapping
    public ResponseEntity<List<Episodio>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Episodio> consultar(@PathVariable("id") Integer id) {
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
