package br.iesp.edu.api.resource;

import br.iesp.edu.api.entity.Pessoa;
import br.iesp.edu.api.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaResource(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public List<Pessoa> getUsers() {
        return (List<Pessoa>) pessoaService.listar();
    }

    @PostMapping
    void addUser(@RequestBody Pessoa usuario) {
        pessoaService.salvar(usuario);
    }

}
