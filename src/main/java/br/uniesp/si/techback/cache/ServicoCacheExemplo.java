package br.uniesp.si.techback.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Serviço de exemplo que demonstra o uso de cache com Spring Cache.
 * Este serviço simula um repositório de usuários com operações de cache.
 */
@Service
public class ServicoCacheExemplo {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServicoCacheExemplo.class);
    
    // Simulando um banco de dados em memória
    private final Map<String, String> bancoDeDados = new HashMap<>();
    
    /**
     * Busca um usuário pelo ID. Se o usuário estiver em cache, retorna do cache.
     * Caso contrário, busca no "banco de dados" e armazena no cache.
     */
    @Cacheable(value = "usuarios", key = "#id")
    public String buscarUsuario(String id) {
        LOGGER.info("Buscando usuário no banco de dados: {}", id);
        // Simula uma consulta demorada
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return bancoDeDados.getOrDefault(id, "Usuário não encontrado");
    }
    
    /**
     * Atualiza um usuário no banco de dados e no cache.
     */
    @CachePut(value = "usuarios", key = "#id")
    public String atualizarUsuario(String id, String nome) {
        LOGGER.info("Atualizando usuário: {} com nome: {}", id, nome);
        bancoDeDados.put(id, nome);
        return nome;
    }
    
    /**
     * Remove um usuário do cache.
     */
    @CacheEvict(value = "usuarios", key = "#id")
    public void removerDoCache(String id) {
        LOGGER.info("Removendo usuário do cache: {}", id);
        // A anotação @CacheEvict já remove o item do cache
    }
    
    /**
     * Limpa todo o cache de usuários.
     */
    @CacheEvict(value = "usuarios", allEntries = true)
    public void limparCache() {
        LOGGER.info("Limpando todo o cache de usuários");
    }
    
    /**
     * Cria um novo usuário com ID aleatório.
     */
    public String criarUsuario(String nome) {
        String id = UUID.randomUUID().toString();
        bancoDeDados.put(id, nome);
        return id;
    }
}
