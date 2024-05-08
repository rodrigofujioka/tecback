package br.com.fujideia.iesp.tecback.client;

import br.com.fujideia.iesp.tecback.model.Personagem;
import jakarta.persistence.ForeignKey;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "personagens",
        url = "http://localhost:9191")
public interface PersonagemClient {

    @GetMapping("/personagens")
    public List<Personagem> listarPersonagens();
}
