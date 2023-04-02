package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter


@Entity
@Table(name="tb_cliente")
//para colocar um nome na tabela
public class Cliente {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 11)
    private String CPF;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 13)
    private Integer telefone;

    @Column(nullable = false)
    private Date data_nascimento;

    @Column(nullable = false, length = 8)
    private Integer cep;

    @Column(nullable = false)
    private Integer plano;

    @Column(nullable = false)
    private Date data_contratacao;



}
