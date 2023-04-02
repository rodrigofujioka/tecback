package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;

@Getter
@Setter


@Entity
@Table(name="tb_usuario")
//para colocar um nome na tabela
public class Usuario {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nome_usuario;

    @Column(nullable = false)
    private UUID senha;

    @Column(nullable = false)
    private Integer tipo_usuario;

    @Column(nullable = false)
    private Integer id_cliente;


}
