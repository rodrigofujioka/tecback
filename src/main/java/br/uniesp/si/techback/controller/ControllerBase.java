package br.uniesp.si.techback.controller;


import br.uniesp.si.techback.model.EntidadeBase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class ControllerBase {

    @GetMapping
    public EntidadeBase exemploMetodoGET() {
        return EntidadeBase
                .builder()
                .nome("Aula BackEnd")
                .ano(2025)
                .build();
    }


    @GetMapping
    public EntidadeBase exemploMetodoPost(@RequestBody EntidadeBase entidadeBase) {
        return entidadeBase;
    }


}
