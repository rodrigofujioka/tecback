package br.uniesp.si.techback.model.dto;

import lombok.Data;

@Data
public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String perfil;
    private Boolean ativo;
}
