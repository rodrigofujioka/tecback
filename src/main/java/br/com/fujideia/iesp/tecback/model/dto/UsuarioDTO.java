package br.com.fujideia.iesp.tecback.model.dto;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsuarioDTO {

    private int idade;
    private String nome;
    @Email @NotEmpty
    private String email;

    private String sobrenome;




}
