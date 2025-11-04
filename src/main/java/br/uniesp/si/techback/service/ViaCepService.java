package br.uniesp.si.techback.service;

import br.uniesp.si.techback.dto.ViaCepResponse;
import br.uniesp.si.techback.exception.CepInvalidoException;
import br.uniesp.si.techback.exception.CepNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ViaCepService {

    private static final String VIA_CEP_URL = "https://viacep.com.br/ws/{cep}/json/";

    private final RestTemplate restTemplate;

    /**
     * Busca os dados de um endereço a partir de um CEP
     * @param cep CEP a ser consultado (apenas números)
     * @return Dados do endereço correspondente ao CEP
     * @throws CepNaoEncontradoException quando o CEP não for encontrado
     */
    public ViaCepResponse buscarEnderecoPorCep(String cep) {
        // Remove caracteres não numéricos do CEP
        String cepLimpo = cep.replaceAll("[^0-9]", "");
        
        // Valida o CEP
        if (cepLimpo.length() != 8) {
            throw new CepInvalidoException(cep);
        }

        try {
            // Faz a requisição para a API do ViaCEP
            ViaCepResponse response = restTemplate.getForObject(
                    VIA_CEP_URL, 
                    ViaCepResponse.class, 
                    cepLimpo
            );

            // Verifica se o CEP foi encontrado
            if (response == null || response.isErro()) {
                throw new CepNaoEncontradoException(cep);
            }

            return response;
        } catch (HttpClientErrorException.BadRequest ex) {
            throw new CepInvalidoException(cep);
        }
    }
}
