package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Entity
@Table(name="tb_forma_pagamento")
//para colocar um nome na tabela
public class Forma_Pagamento {

    @Id
    @GeneratedValue
    private Integer id;


}
