package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_episodio")
public class Episodio implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String titulo;
    private Integer numero;
    @ManyToOne
    private Serie serie;
}
