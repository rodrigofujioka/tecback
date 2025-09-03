package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Filme;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private List<Filme> lista = new ArrayList<>();
    private long contador = 1;

    @PostMapping
    public Filme incluir(@RequestBody Filme filme){

        filme.setId(contador);
        ++contador;
        lista.add(filme);
        return filme;

    }

    @GetMapping
    public List<Filme> listar(){
        return lista;
    }

}
