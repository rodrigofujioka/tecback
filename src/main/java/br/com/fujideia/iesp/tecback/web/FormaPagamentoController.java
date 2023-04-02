package br.com.fujideia.iesp.tecback.web;


import br.com.fujideia.iesp.tecback.model.Forma_Pagamento;
import br.com.fujideia.iesp.tecback.service.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formaPagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoService service;

    @PostMapping
    public ResponseEntity<Forma_Pagamento> salvar(Forma_Pagamento forma_pagamento){

        forma_pagamento = service.salvar(forma_pagamento);
        return ResponseEntity.ok(forma_pagamento);

    }

    @PutMapping
    public ResponseEntity<Forma_Pagamento> alterar(@RequestBody Forma_Pagamento forma_pagamento){
        forma_pagamento = service.alterar(forma_pagamento);
        return ResponseEntity.ok(forma_pagamento);
    }

    @GetMapping
    public ResponseEntity<List<Forma_Pagamento>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Forma_Pagamento> consultar(@PathVariable("id") Integer id){
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
