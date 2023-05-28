package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Entity
@Table(name="tb_forma_pagamento")
//para colocar um nome na tabela
public class Forma_Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true)
    private Integer numero_cartao;
    @Column(nullable = false)
    private Integer codigo_seguranca;
    @Column(nullable = false)
    private String titular_cartao;
    private Integer id_cliente;

}
