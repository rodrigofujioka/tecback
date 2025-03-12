package br.uniesp.si.techback.controller;


import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired //Iremos remover essa anotação na próxma aula
    private FilmeRepository filmeRepository;

    @GetMapping
    public List<Filme> listar(){
        return filmeRepository.findAll();
    }

    @PostMapping
    public Filme inserir(@RequestBody Filme filme){
        return filmeRepository.save(filme);
    }
}
