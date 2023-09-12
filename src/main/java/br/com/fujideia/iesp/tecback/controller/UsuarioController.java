package br.com.fujideia.iesp.tecback.controller;


import br.com.fujideia.iesp.tecback.model.Usuario;
import br.com.fujideia.iesp.tecback.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;
    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
        usuario = service.salvar(usuario);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarPorId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.consultarPorId(id));
    }
    @PutMapping
    public ResponseEntity<Usuario> alterar(@RequestBody Usuario usuario){
        return ResponseEntity.ok(service.alterar(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.excluir(id));
    }
}
