package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter


@Entity
@Table(name="tb_cliente")
//para colocar um nome na tabela
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nome_cliente;

    @Column(nullable = false, unique = true, length = 11)
    private String CPF;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 13)
    private Integer telefone;

    @Column(nullable = false)
    private Date data_nascimento;

    private LocalDateTime data_contratacao;

    private Integer id_plano;



}
