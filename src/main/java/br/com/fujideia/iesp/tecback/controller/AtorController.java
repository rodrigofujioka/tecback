package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.dto.AtorDTO;
import br.com.fujideia.iesp.tecback.service.AtorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atores")
@RequiredArgsConstructor
@Slf4j
public class AtorController {

    private final AtorService atorService;

    @GetMapping
    public ResponseEntity<List<AtorDTO>> listarTodos() {
        log.info("Chamando listarTodos no AtorController");
        List<AtorDTO> atores = atorService.listAll();
        return ResponseEntity.ok(atores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtorDTO> buscarPorId(@PathVariable Long id) {
        log.info("Chamando buscarPorId no AtorController com id: {}", id);
        Optional<AtorDTO> ator = atorService.buscarPorId(id);
        return ator.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AtorDTO> criarAtor(@RequestBody AtorDTO atorDTO) {
        log.info("Chamando criarAtor no AtorController com dados: {}", atorDTO);
        AtorDTO atorCriado = atorService.createAtor(atorDTO);
        return ResponseEntity.ok(atorCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtorDTO> atualizarAtor(@PathVariable Long id, @RequestBody AtorDTO atorDTO) {
        log.info("Chamando atualizarAtor no AtorController com id: {} e dados: {}", id, atorDTO);
        Optional<AtorDTO> atorAtualizado = Optional.ofNullable(atorService.updateAtor(id, atorDTO));
        return atorAtualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAtor(@PathVariable Long id) {
        log.info("Chamando deletarAtor no AtorController com id: {}", id);
        boolean deletado = atorService.deleteAtor(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
