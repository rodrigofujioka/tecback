package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_user")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    @Column(name = "dtNascimento")
    private String dataNasc;
    private String email;
    @Column(name = "senha")
    private String senha;
    @Column(name = "nrCartao", length = 16)
    private String numCartao;
    private String validadeCartao;
    private String codSeguranca;
    private String titularNome;
    @Column(name = "nrCpf", length = 11)
    private String cpf;
}
