package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.dto.UsuarioDTO;
import br.com.fujideia.iesp.tecback.model.Usuario;
import br.com.fujideia.iesp.tecback.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO user) throws Exception {
        UsuarioDTO usuario = service.salvar(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> alterar(@PathVariable("id") Long id, @RequestBody UsuarioDTO user) throws Exception {
        service.alterar(user, id);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> consultar (@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(service.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluir (@PathVariable("id") Long id) {
        if (service.excluir(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
