package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.clients.ViaCepClient;
import br.com.fujideia.iesp.tecback.model.Endereco;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    private ViaCepClient viaCepClient;

    @GetMapping("/{cep}")
    public Endereco consultaCep(@PathVariable String cep){
        return viaCepClient.consultaEndereco(cep);
    }
}
