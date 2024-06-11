package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Cartao;
import br.com.fujideia.iesp.tecback.repository.CartaoRepository;
import br.com.fujideia.iesp.tecback.service.CartaoService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/cartao")
public class CartaoController {

    private CartaoService cartaoService;
    @PostMapping
    public ResponseEntity<?> salvar(@Valid @RequestBody Cartao cartao, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        Cartao salvarCartao = cartaoService.salvar(cartao);
        return new ResponseEntity<>(salvarCartao, HttpStatus.CREATED);
    }

    @PutMapping
    public Cartao atualizar(@RequestBody Cartao cartao){
        return cartaoService.atualizar(cartao);
    }

    @GetMapping("/{id}")
    public Cartao buscarPorNumero(@PathVariable Integer numero){
        return cartaoService.buscarPorNumero(numero);
    }

    @GetMapping
    public List<Cartao> listarTodos(){
        return cartaoService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void excluirPorNumero(@PathVariable Integer numero){
        cartaoService.excluirPorNumero(numero);
    }
}
