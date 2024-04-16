package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Getter;
//import java.util.List;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    //@OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
    //private List<Filme> filmes;
    // getters e setters
}

