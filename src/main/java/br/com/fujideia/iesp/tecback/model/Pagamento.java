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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date data_pagamento;

    private Date data_vencimento;

    private Integer id_plano;

    private Integer id_cliente;

}
