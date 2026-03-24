package br.uniesp.si.techback.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    @PostMapping
    public String criar(){
        return "Posta Criacao de Genero Criado";
    }

    public String listar(){
        return "Listar";
    }
}

