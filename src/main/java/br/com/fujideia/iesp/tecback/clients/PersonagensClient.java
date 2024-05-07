package br.com.fujideia.iesp.tecback.clients;

import br.com.fujideia.iesp.tecback.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "personagens",
        url = "http://localhost:9191")
public interface PersonagensClient {

    @GetMapping("/personagens")
    public List<String> listarPersonagens();
}
