package br.com.fujideia.iesp.tecback.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioDTO {

    private String nomeCompleto;
    private String dataNasc;
    private String email;
    private String senha;
    private String numCartao;
    private String validadeCartao;
    private String codSeguranca;
    private String titularNome;
    private String cpf;
}
