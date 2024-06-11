package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "O nome não pode estar vazio")
    @Size(min = 2, max = 30, message = "O nome deve conter entre 2 e 30 caracteres")
    private String nome;
}
