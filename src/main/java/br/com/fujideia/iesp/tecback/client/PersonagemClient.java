package br.com.fujideia.iesp.tecback.client;

import br.com.fujideia.iesp.tecback.model.Personagem;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "personagens",
        url = "http://localhost:8080")
public interface PersonagemClient {

    @GetMapping("/personagens")
    public List<Personagem> listarPersonagens();

    @PostMapping
    public Personagem criarPersonagem(@RequestBody Personagem personagem);

    @PutMapping
    public Personagem atualizarPersonagem(@RequestBody Personagem personagem);

    @GetMapping
    public Personagem buscarPorId(@PathVariable Integer id);

    @DeleteMapping
    public void excluirPorId(@PathVariable Integer id);


}
