package br.com.fujideia.iesp.tecback.web;

import br.com.fujideia.iesp.tecback.model.Classificacao_Etaria;
import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.service.ClassificacaoEtariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classificacaoEtaria")
public class ClassificacaoEtariaController {

    @Autowired
    private ClassificacaoEtariaService service;

    @PostMapping
    public ResponseEntity<Classificacao_Etaria> salvar(@RequestBody Classificacao_Etaria classificacao_etaria){

        classificacao_etaria = service.salvar(classificacao_etaria);
        return ResponseEntity.ok(classificacao_etaria);

    }

    @PutMapping
    public ResponseEntity<Classificacao_Etaria> alterar(@RequestBody Classificacao_Etaria classificacao_etaria){
        classificacao_etaria = service.alterar(classificacao_etaria);
        return ResponseEntity.ok(classificacao_etaria);
    }

    @GetMapping
    public ResponseEntity<List<Classificacao_Etaria>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classificacao_Etaria> consultar(@PathVariable("id") Integer id){
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
