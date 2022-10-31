package br.iesp.edu.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class PessoaDTO {

    private String nome;
    @Email(message = "E-mail invalido")
    private String email;
    @DecimalMax(value = "999999.9" , message = "Teste")
    @Pattern(regexp = "^-?\\d{1,19}$", message = "Alow mundo")
    private Long teste;

}
