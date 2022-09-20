package br.iesp.edu.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;

@Entity
@Getter
@Setter
public class Filme {

    @Id
    @GeneratedValue
    private Integer id;
    private String titulo;
    private String genero;
    private int ano;

}
