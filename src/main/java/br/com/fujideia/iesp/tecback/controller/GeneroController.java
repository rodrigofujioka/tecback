package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.dto.GeneroDTO;
import br.com.fujideia.iesp.tecback.service.GeneroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/generos")
@RequiredArgsConstructor
@Slf4j
public class GeneroController {

    private final GeneroService generoService;

    @GetMapping
    public ResponseEntity<List<GeneroDTO>> listarTodos() {
        log.info("Chamando listarTodos no GeneroController");
        List<GeneroDTO> generos = generoService.listarTodos();
        return ResponseEntity.ok(generos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneroDTO> buscarPorId(@PathVariable Long id) {
        log.info("Chamando buscarPorId no GeneroController com id: {}", id);
        Optional<GeneroDTO> genero = generoService.buscarPorId(id);
        return genero.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GeneroDTO> criarGenero(@RequestBody GeneroDTO generoDTO) {
        log.info("Chamando criarGenero no GeneroController com dados: {}", generoDTO);
        GeneroDTO generoCriado = generoService.criarGenero(generoDTO);
        return ResponseEntity.ok(generoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneroDTO> atualizarGenero(@PathVariable Long id, @RequestBody GeneroDTO generoDTO) {
        log.info("Chamando atualizarGenero no GeneroController com id: {} e dados: {}", id, generoDTO);
        Optional<GeneroDTO> generoAtualizado = generoService.atualizarGenero(id, generoDTO);
        return generoAtualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarGenero(@PathVariable Long id) {
        log.info("Chamando deletarGenero no GeneroController com id: {}", id);
        boolean deletado = generoService.deletarGenero(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
