package br.uniesp.si.techback.model.dto;

import br.uniesp.si.techback.validator.ApenasIespEmail;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório")
    @ApenasIespEmail
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    private String senha;

    private String perfil;

    private Boolean ativo = true;
}
