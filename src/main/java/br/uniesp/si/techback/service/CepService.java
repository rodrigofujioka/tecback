package br.uniesp.si.techback.service;

import br.uniesp.si.techback.client.ViaCepClient;
import br.uniesp.si.techback.model.dto.EnderecoViaCepDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CepService {

    private final ViaCepClient viaCepClient;

    public EnderecoViaCepDTO buscarEnderecoPorCep(String cep) {
        return viaCepClient.consultarCep(cep);
    }
}
