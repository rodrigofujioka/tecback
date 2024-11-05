package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.client.ViaCepClient;
import br.com.fujideia.iesp.tecback.model.dto.EnderecoDTO;
import org.springframework.stereotype.Service;

@Service
public class ViaCepService {

    private final ViaCepClient viaCepClient;

    public ViaCepService(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    public EnderecoDTO buscarEndereco(String cep) {
        return viaCepClient.buscarEnderecoPorCep(cep);
    }

}
