package br.com.fujideia.iesp.tecback.web;


import br.com.fujideia.iesp.tecback.model.Tipo_Usuario;
import br.com.fujideia.iesp.tecback.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoUsuario")
public class TipoUsuarioController {
    @Autowired
    private TipoUsuarioService service;

    @PostMapping
    public ResponseEntity<Tipo_Usuario> salvar(Tipo_Usuario tipo_usuario){

        tipo_usuario = service.salvar(tipo_usuario);
        return ResponseEntity.ok(tipo_usuario);

    }

    @PutMapping
    public ResponseEntity<Tipo_Usuario> alterar(@RequestBody Tipo_Usuario tipo_usuario){
        tipo_usuario = service.alterar(tipo_usuario);
        return ResponseEntity.ok(tipo_usuario);
    }

    @GetMapping
    public ResponseEntity<List<Tipo_Usuario>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipo_Usuario> consultar(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") Integer id){
        if(service.excluir(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
