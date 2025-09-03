package br.uniesp.si.techback.controller;
import br.uniesp.si.techback.model.Genero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


public class GeneroController {

    private List<Genero> lista = new ArrayList<>();
    private long contador = 1;

    @PostMapping
    public Genero incluir(@RequestBody Genero genero){

        genero.setId(contador);
        ++contador;
        lista.add(genero);
        return genero;

    }


    public List<Genero> listar(){
        return lista;
    }

}
