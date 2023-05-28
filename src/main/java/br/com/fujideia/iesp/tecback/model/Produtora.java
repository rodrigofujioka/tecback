package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Entity
@Table(name="tb_produtora")
//para colocar um nome na tabela
public class Produtora {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 14)
    private String CNPJ;

    @Column(nullable = false, length = 50)
    private String origem;


}
