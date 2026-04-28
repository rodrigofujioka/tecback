package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.dto.FilmeDTO;
import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.service.FilmeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
@Slf4j
public class FilmeController {

    private final FilmeService filmeService;

    @GetMapping("/ordenado")
    public List<Filme> listarOrdenado() {
        log.info("Listando todos os filmes");
        return filmeService.listarOrdenado();
    }

    @GetMapping
    public List<FilmeDTO> listar() {
        log.info("Listando todos os filmes");
        List<FilmeDTO> filmes = filmeService.listar();
        log.debug("Total de filmes encontrados: {}", filmes.size());
        return filmes;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeDTO> buscarPorId(@PathVariable Long id) {
        try {
            FilmeDTO filme = filmeService.buscarPorId(id);
            log.debug("Filme encontrado: {}", filme);
            return ResponseEntity.ok(filme);
        } catch (Exception e) {
            log.error("Erro ao buscar filme com ID {}: {}", id, e.getMessage(), e);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<FilmeDTO> criar(@Valid @RequestBody FilmeDTO filmeDTO) {
        log.info("Recebida requisição para criar novo filme: {}", filmeDTO.getTitulo());
        try {
            FilmeDTO filmeSalvo = filmeService.salvar(filmeDTO);
            log.info("Filme criado com sucesso. ID: {}, Título: {}", filmeSalvo.getId(), filmeSalvo.getTitulo());
            
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(filmeSalvo.getId())
                    .toUri();
            log.debug("URI de localização do novo filme: {}", location);
            
            return ResponseEntity.created(location).body(filmeSalvo);
        } catch (Exception e) {
            log.error("Erro ao criar filme: {}", e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmeDTO> atualizar(@PathVariable Long id, @Valid @RequestBody FilmeDTO filmeDTO) {
        log.info("Atualizando filme com ID {}: {}", id, filmeDTO);
        try {
            FilmeDTO filmeAtualizado = filmeService.atualizar(id, filmeDTO);
            log.debug("Filme ID {} atualizado com sucesso", id);
            return ResponseEntity.ok(filmeAtualizado);
        } catch (Exception e) {
            log.error("Erro ao atualizar filme ID {}: {}", id, e.getMessage(), e);
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        log.info("Excluindo filme com ID: {}", id);
        try {
            filmeService.excluir(id);
            log.debug("Filme com ID {} excluído com sucesso", id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error("Erro ao excluir filme com ID {}: {}", id, e.getMessage(), e);
            return ResponseEntity.notFound().build();
        }
    }


}
