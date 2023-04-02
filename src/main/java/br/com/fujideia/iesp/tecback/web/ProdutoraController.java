package br.com.fujideia.iesp.tecback.web;


import br.com.fujideia.iesp.tecback.model.Produtora;
import br.com.fujideia.iesp.tecback.service.ProdutoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtora")
public class ProdutoraController {
    @Autowired
    private ProdutoraService service;

    @PostMapping
    public ResponseEntity<Produtora> salvar(Produtora produtora){

        produtora = service.salvar(produtora);
        return ResponseEntity.ok(produtora);

    }

    @PutMapping
    public ResponseEntity<Produtora> alterar(@RequestBody Produtora produtora){
        produtora = service.alterar(produtora);
        return ResponseEntity.ok(produtora);
    }

    @GetMapping
    public ResponseEntity<List<Produtora>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtora> consultar(@PathVariable("id") Integer id){
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
