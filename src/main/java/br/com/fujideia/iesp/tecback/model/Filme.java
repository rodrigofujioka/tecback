package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name="tb_filme")
//para colocar um nome na tabela
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 500)
    private String sinopse;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false)
    private Double duracao;

    private Integer id_genero;

    private Integer id_produtora;

    private Integer id_diretor;

    private Integer id_classificacao_etaria;




}
