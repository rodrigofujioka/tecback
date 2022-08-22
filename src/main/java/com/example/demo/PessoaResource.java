package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

    @GetMapping("/consultar")
    public Pessoa getPessoa(){
        Pessoa p = new Pessoa();
        p.setNome("Rodrigo");
        p.setIdade(39);
        return  p;
    }

}
