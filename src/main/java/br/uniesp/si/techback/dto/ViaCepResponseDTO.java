package br.uniesp.si.techback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ViaCepResponseDTO {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    @JsonProperty("erro")
    private Boolean erro;
}

