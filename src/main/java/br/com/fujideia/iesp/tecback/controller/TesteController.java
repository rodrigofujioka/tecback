package br.com.fujideia.iesp.tecback.controller;


import br.com.fujideia.iesp.tecback.model.Teste;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @GetMapping
    public Teste teste(){
        return new Teste();
    }
}
