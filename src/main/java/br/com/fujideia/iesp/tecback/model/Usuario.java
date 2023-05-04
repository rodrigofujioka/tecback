package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue
    private int id;


    @Column(unique = true)
    private String login;

    private int anoNascimento;

    private String nome;

    private String sobrenome;
    private String cpf;

    private String email;


    @OneToMany
    private List<Favoritos> listaFavoritos;

}
