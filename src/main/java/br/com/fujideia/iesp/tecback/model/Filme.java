package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Entity
@Table(name="tb_filme")
//para colocar um nome na tabela
public class Filme {

    @Id
    @GeneratedValue
    private Integer id;


    private String titulo;

    @Column(name= "ds_sinopse", length = 500)
    private String sinopse;




}
