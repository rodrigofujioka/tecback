package br.com.fujideia.iesp.tecback.model;

import br.com.fujideia.iesp.tecback.validator.IdadeRange;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "O nome não pode estar vazio")
    @Size(min = 2, max = 30, message = "O nome deve ter entre 2 e 30 caracteres")
    private String nome;

    @NotEmpty(message = "O email não pode estar vazio")
    @Email(message = "Formato de email inválido")
    private String email;

    private String senha;

    @IdadeRange(min = 18, max = 120, message = "A idade deve estar entre 18 e 120 anos.")
    private int idade;
}
