package br.com.fujideia.iesp.tecback.controller;


import br.com.fujideia.iesp.tecback.client.PersonagemClient;
import br.com.fujideia.iesp.tecback.model.Personagem;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/personagem")
@RestController
public class PersonagemController {

    @Autowired
    private PersonagemClient personagemClient;

    @PostMapping
    public Personagem criarPersonagem(@RequestBody Personagem personagem){
        return personagemClient.criarPersonagem(personagem);
    }
    @PutMapping
    public Personagem atualizarPersonagem(@RequestBody Personagem personagem){
        return personagemClient.atualizarPersonagem(personagem);
    }

    @GetMapping("/{id}")
    public Personagem buscarPorId(@PathVariable Integer id){
        return personagemClient.buscarPorId(id);
    }

    @GetMapping
    public List<Personagem> listarPersonagem(){
        return personagemClient.listarPersonagens();
    }

    @DeleteMapping("/{id}")
    public void excluirPorId(@PathVariable Integer id){
        personagemClient.excluirPorId(id);
    }

}
