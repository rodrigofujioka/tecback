package br.com.fujideia.iesp.tecback.web;

import br.com.fujideia.iesp.tecback.dtos.CadastroDto;
import br.com.fujideia.iesp.tecback.model.Cliente;
import br.com.fujideia.iesp.tecback.model.Forma_Pagamento;
import br.com.fujideia.iesp.tecback.model.Pagamento;
import br.com.fujideia.iesp.tecback.model.Usuario;
import br.com.fujideia.iesp.tecback.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;
    @Autowired
    private FormaPagamentoService formaPagamentoService;
    @Autowired
    private PagamentoService pagamentoService;
    @Autowired
    private PlanoService planoService;
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("cadastrar")
    public ResponseEntity<CadastroDto> salvar(@RequestBody @Validated CadastroDto cadastroDto){
        CadastroDto cliente = service.salvar(cadastroDto);
        CadastroDto fp = formaPagamentoService.salvar(cadastroDto, cliente.getCliente().getId());
        Usuario usuario = new Usuario();
        Pagamento pagamento = new Pagamento();
        Date date = new Date();
        usuario.setNome_usuario(cliente.getCliente().getNome_cliente());
        usuario.setId_cliente(cliente.getCliente().getId());
        usuario.setSenha(cadastroDto.getSenha());
        usuario.setEmail(cliente.getCliente().getEmail());
        usuarioService.salvar(usuario);
        pagamento.setId_cliente(cliente.getCliente().getId());
        pagamento.setData_pagamento(date);
        pagamento.setData_vencimento(date);
        pagamento.setId_plano(cliente.getCliente().getId_plano());
        pagamentoService.salvar(pagamento);

        return ResponseEntity.ok(cadastroDto);
    }

    @PutMapping
    public ResponseEntity<Cliente> alterar(@RequestBody Cliente cliente){
        cliente = service.alterar(cliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> consultar(@PathVariable("id") Integer id){
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
