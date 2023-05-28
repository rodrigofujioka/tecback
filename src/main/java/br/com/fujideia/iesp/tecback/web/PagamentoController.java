package br.com.fujideia.iesp.tecback.web;

import br.com.fujideia.iesp.tecback.dtos.CadastroDto;
import br.com.fujideia.iesp.tecback.model.Cliente;
import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.model.Pagamento;
import br.com.fujideia.iesp.tecback.service.PagamentoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @PostMapping
    public ResponseEntity<Pagamento> salvar(@RequestBody Pagamento pagamento){

        pagamento = service.salvar(pagamento);
        return ResponseEntity.ok(pagamento);

    }

    @PutMapping
    public ResponseEntity<Pagamento> alterar(@RequestBody Pagamento pagamento){
        pagamento = service.alterar(pagamento);
        return ResponseEntity.ok(pagamento);
    }

    @GetMapping
    public ResponseEntity<List<Pagamento>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> consultar(@PathVariable("id") Integer id){
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
