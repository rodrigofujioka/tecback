package br.com.fujideia.iesp.tecback.controller;


import br.com.fujideia.iesp.tecback.client.PersonagemClient;
import br.com.fujideia.iesp.tecback.model.Personagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/personagem")
@RestController
public class PersonagemController {

    @Autowired
    private PersonagemClient personagemClient;

    @GetMapping
    public List<Personagem> listarPersonagem(){
        return personagemClient.listarPersonagens();
    }
}
