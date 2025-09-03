package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Genero;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/generos")
public class GeneroController {

    public List<Genero> listaGenero = new ArrayList<>();
    private long contador = 1;

    @PostMapping
    public Genero incluirGenero(@RequestBody Genero genero) {
        genero.setId(contador);
        ++contador;
        listaGenero.add(genero);
        return genero;
    }

    @GetMapping
    public List<Genero> listarGenero() {
        return listaGenero;
    }
}
