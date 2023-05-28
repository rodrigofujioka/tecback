package br.com.fujideia.iesp.tecback.web;

import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.model.Plano;
import br.com.fujideia.iesp.tecback.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plano")
public class PlanoController {

    @Autowired
    private PlanoService service;

    @PostMapping("/post")
    public ResponseEntity<Plano> salvar(@RequestBody Plano plano){

        plano = service.salvar(plano);
        return ResponseEntity.ok(plano);

    }

    @PutMapping
    public ResponseEntity<Plano> alterar(@RequestBody Plano plano){
        plano = service.alterar(plano);
        return ResponseEntity.ok(plano);
    }

    @GetMapping
    public ResponseEntity<List<Plano>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plano> consultar(@PathVariable("id") Integer id){
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
