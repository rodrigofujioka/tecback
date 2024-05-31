package br.com.fujideia.iesp.tecback.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "personagens", url = "https://localhost:9191")
public interface PersonagemClient {

    @GetMapping("/personagens")
    public List<String> listarPersonagem();
 }
