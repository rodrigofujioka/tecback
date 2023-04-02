package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter


@Entity
@Table(name="tb_pagamento")
//para colocar um nome na tabela
public class Pagamento {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private Integer id_cliente;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private Date data_pagamento;

    @Column(nullable = false)
    private Date data_vencimento;

    @Column(nullable = false)
    private Integer id_plano;

    @Column(nullable = false)
    private Integer id_formapagamento;

    @Column(nullable = false)
    private Double saldo;


}
