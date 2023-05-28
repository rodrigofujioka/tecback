package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;

import java.util.List;

@Getter
@Setter

@Entity
@Table(name="tb_usuario")
//para colocar um nome na tabela
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nome_usuario;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private int id_cliente;

    @Column(nullable = false)
    private String email;


}
