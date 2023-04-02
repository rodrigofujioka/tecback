package br.com.fujideia.iesp.tecback.web;


import br.com.fujideia.iesp.tecback.model.Diretor;
import br.com.fujideia.iesp.tecback.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretor")
public class DiretorController {

    @Autowired
    private DiretorService service;

    @PostMapping
    public ResponseEntity<Diretor> salvar(Diretor diretor){

        diretor = service.salvar(diretor);
        return ResponseEntity.ok(diretor);

    }

    @PutMapping
    public ResponseEntity<Diretor> alterar(@RequestBody Diretor diretor){
        diretor = service.alterar(diretor);
        return ResponseEntity.ok(diretor);
    }

    @GetMapping
    public ResponseEntity<List<Diretor>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diretor> consultar(@PathVariable("id") Integer id){
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
