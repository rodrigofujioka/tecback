package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.cache.ServicoCacheExemplo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cache")
public class CacheController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheController.class);
    
    private final ServicoCacheExemplo servicoCacheExemplo;

    public CacheController(ServicoCacheExemplo servicoCacheExemplo) {
        this.servicoCacheExemplo = servicoCacheExemplo;
    }
    public ResponseEntity<String> criarUsuario(@RequestParam String nome) {
        String id = servicoCacheExemplo.criarUsuario(nome);
        return ResponseEntity.ok("Usuário criado com ID: " + id);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<String> buscarUsuario(@PathVariable String id) {
        long inicio = System.currentTimeMillis();
        String usuario = servicoCacheExemplo.buscarUsuario(id);
        long tempo = System.currentTimeMillis() - inicio;
        
        LOGGER.info("Tempo de busca: {}ms", tempo);
        return ResponseEntity.ok(usuario + " (Tempo: " + tempo + "ms)");
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<String> atualizarUsuario(
            @PathVariable String id, 
            @RequestParam String nome) {
        
        servicoCacheExemplo.atualizarUsuario(id, nome);
        return ResponseEntity.ok("Usuário atualizado com sucesso");
    }

    @DeleteMapping("/usuarios/{id}/cache")
    public ResponseEntity<String> removerDoCache(@PathVariable String id) {
        servicoCacheExemplo.removerDoCache(id);
        return ResponseEntity.ok("Usuário removido do cache");
    }

    @DeleteMapping("/usuarios/cache")
    public ResponseEntity<String> limparCache() {
        servicoCacheExemplo.limparCache();
        return ResponseEntity.ok("Cache limpo com sucesso");
    }
}
