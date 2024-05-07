package br.com.fujideia.iesp.tecback.clients;

import br.com.fujideia.iesp.tecback.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCep", url = "https://viacep.com.br/ws/")
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    public String consultaEndereco(@PathVariable String cep);
}
