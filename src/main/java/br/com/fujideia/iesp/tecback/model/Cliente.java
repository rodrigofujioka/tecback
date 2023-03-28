package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Entity
@Table(name="tb_cliente")
//para colocar um nome na tabela
public class Cliente {

    @Id
    @GeneratedValue
    private Integer id;


    private String nome;


    private String CPF;

    //@Transient- ignora para não ir para o banco

    @Transient
    private  String teste;


}
