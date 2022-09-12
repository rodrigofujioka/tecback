package br.iesp.edu.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private String email;
}
