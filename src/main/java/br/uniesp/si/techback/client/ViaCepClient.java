package br.uniesp.si.techback.client;

import br.uniesp.si.techback.dto.ViaCepResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCepClient", url = "${viacep.url:https://viacep.com.br/ws}")
public interface ViaCepClient {

    @GetMapping("/{cep}/json/")
    ViaCepResponseDTO buscarPorCep(@PathVariable("cep") String cep);
}

