package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue
    private int id;


    private String login;

    @NotNull
    private Integer anoNascimento;

    private String nome;

    private String sobrenome;
    private String cpf;
    private String email;
    @OneToMany
    private List<Favoritos> listaFavoritos;

}
