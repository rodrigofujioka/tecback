package br.com.fujideia.iesp.tecback.controller;


import br.com.fujideia.iesp.tecback.model.Genero;
import br.com.fujideia.iesp.tecback.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    @Autowired
    private GeneroService service;
    @PostMapping
    public Genero salvar(@RequestBody Genero genero){
        return service.salvar(genero);
    }

    @PutMapping
    public Genero atualizar(@RequestBody Genero genero){
        return service.atualizar(genero);
    }

    @GetMapping
    public List<Genero> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Genero buscarPorId(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluirPorId(@PathVariable Integer id){
        service.excluir(id);
    }

    // Implemente endpoints para CRUD de genero
}
