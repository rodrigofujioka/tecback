package br.com.fujideia.iesp.tecback.model.dto;


import lombok.Data;

@Data
public class EnderecoDTO {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}
