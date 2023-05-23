package br.com.fujideia.iesp.tecback.model.dto;


import br.com.fujideia.iesp.tecback.validator.NomeValidation;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsuarioNomeEmailDTO
{
    @NomeValidation
    private String nome;
    @Email @NotEmpty
    private String email;

}
