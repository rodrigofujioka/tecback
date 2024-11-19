package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.dto.DiretorDTO;
import br.com.fujideia.iesp.tecback.service.DiretorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private final DiretorService diretorService;

    public DiretorController(DiretorService diretorService) {
        this.diretorService = diretorService;
    }

    @PostMapping
    public ResponseEntity<DiretorDTO> criarDiretor(@Validated @RequestBody DiretorDTO diretorDTO) {
        DiretorDTO diretorCriado = diretorService.criarDiretor(diretorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(diretorCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiretorDTO> buscarPorId(@PathVariable Long id) {
        Optional<DiretorDTO> diretor = diretorService.buscarPorId(id);
        return diretor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DiretorDTO>> listarTodos() {
        List<DiretorDTO> diretores = diretorService.listarTodos();
        return ResponseEntity.ok(diretores);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDiretor(@PathVariable Long id) {
        diretorService.deletarDiretor(id);
        return ResponseEntity.noContent().build();
    }
}
