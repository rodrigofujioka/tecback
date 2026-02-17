package br.uniesp.si.techback.controller;

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

    @GetMapping
    public List<Filme> listar() {
        log.info("Listando todos os filmes");
        List<Filme> filmes = filmeService.listar();
        log.debug("Total de filmes encontrados: {}", filmes.size());
        return filmes;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable Long id) {
        try {
            Filme filme = filmeService.buscarPorId(id);
            log.debug("Filme encontrado: {}", filme);
            return ResponseEntity.ok(filme);
        } catch (Exception e) {
            log.error("Erro ao buscar filme com ID {}: {}", id, e.getMessage(), e);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Filme> criar(@Valid @RequestBody Filme filme) {
        log.info("Recebida requisição para criar novo filme: {}", filme.getTitulo());
        try {
            Filme filmeSalvo = filmeService.salvar(filme);
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
    public ResponseEntity<Filme> atualizar(@PathVariable Long id, @Valid @RequestBody Filme filme) {
        log.info("Atualizando filme com ID {}: {}", id, filme);
        try {
            Filme filmeAtualizado = filmeService.atualizar(id, filme);
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

    @GetMapping("/buscar-por-titulo")
    public ResponseEntity<List<Filme>> buscarPorTitulo(@RequestParam String titulo) {
        log.info("Buscando filmes com título contendo: {}", titulo);
        List<Filme> filmes = filmeService.buscarPorTitulo(titulo);
        log.debug("Encontrados {} filmes com título contendo '{}'", filmes.size(), titulo);
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/buscar-por-genero")
    public ResponseEntity<List<Filme>> buscarPorGenero(@RequestParam String genero) {
        log.info("Buscando filmes do gênero: {}", genero);
        List<Filme> filmes = filmeService.buscarPorGenero(genero);
        log.debug("Encontrados {} filmes do gênero '{}'", filmes.size(), genero);
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/buscar-por-classificacao")
    public ResponseEntity<List<Filme>> buscarPorClassificacao(@RequestParam String classificacao) {
        log.info("Buscando filmes com classificação: {}", classificacao);
        List<Filme> filmes = filmeService.buscarPorClassificacao(classificacao);
        log.debug("Encontrados {} filmes com classificação '{}'", filmes.size(), classificacao);
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/buscar-por-duracao-minima")
    public ResponseEntity<List<Filme>> buscarPorDuracaoMinima(@RequestParam int duracaoMinima) {
        log.info("Buscando filmes com duração mínima de {} minutos", duracaoMinima);
        List<Filme> filmes = filmeService.buscarPorDuracaoMinima(duracaoMinima);
        log.debug("Encontrados {} filmes com duração mínima de {} minutos", filmes.size(), duracaoMinima);
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/buscar-por-intervalo-data")
    public ResponseEntity<List<Filme>> buscarPorIntervaloDataLancamento(
            @RequestParam String dataInicio, 
            @RequestParam String dataFim) {
        log.info("Buscando filmes lançados entre {} e {}", dataInicio, dataFim);
        List<Filme> filmes = filmeService.buscarPorIntervaloDataLancamento(dataInicio, dataFim);
        log.debug("Encontrados {} filmes no período especificado", filmes.size());
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/buscar-por-palavra-chave")
    public ResponseEntity<List<Filme>> buscarPorPalavraChaveNaSinopse(@RequestParam String palavraChave) {
        log.info("Buscando filmes com a palavra-chave '{}' na sinopse", palavraChave);
        List<Filme> filmes = filmeService.buscarPorPalavraChaveNaSinopse(palavraChave);
        log.debug("Encontrados {} filmes com a palavra-chave '{}' na sinopse", filmes.size(), palavraChave);
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/contar-por-genero")
    public ResponseEntity<List<Object[]>> contarFilmesPorGenero() {
        log.info("Contando filmes por gênero");
        List<Object[]> contagem = filmeService.contarFilmesPorGenero();
        log.debug("Encontrados {} gêneros diferentes", contagem.size());
        return ResponseEntity.ok(contagem);
    }

    @GetMapping("/ordenados-por-data-lancamento")
    public ResponseEntity<List<Filme>> buscarTodosOrdenadosPorDataLancamento() {
        log.info("Buscando todos os filmes ordenados por data de lançamento");
        List<Filme> filmes = filmeService.buscarTodosOrdenadosPorDataLancamento();
        log.debug("Encontrados {} filmes", filmes.size());
        return ResponseEntity.ok(filmes);
    }
}
