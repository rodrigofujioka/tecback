package br.com.fujideia.iesp.tecback.clients;

import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "personagens", url = "https://localhost:9191")
public interface PersonagemClient {

    public List<String> listarPersonagem();
 }
