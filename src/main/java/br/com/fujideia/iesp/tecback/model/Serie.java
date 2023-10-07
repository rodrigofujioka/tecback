package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_serie")
public class Serie implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String titulo;
    @Column(name = "ds_sinopse", length = 500)
    private String sinopse;
}
