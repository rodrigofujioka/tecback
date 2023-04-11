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


    @OneToMany
    private List<Favoritos> listaFavoritos;

}
