package br.uniesp.si.techback.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import br.uniesp.si.techback.model.Funcionario;
import br.uniesp.si.techback.service.FuncionarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor

public class FuncionarioController {

    private final FuncionarioService service;

    @PostMapping
    public Funcionario salvar(@RequestBody Funcionario func) {
        return service.salvar(func);
    }

    @GetMapping
    public List<Funcionario> listarTodos() {
        return service.listarTodos();
    }

    @PutMapping("/{id}")
    public Funcionario atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario){
        return service.atualizar(id, funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

