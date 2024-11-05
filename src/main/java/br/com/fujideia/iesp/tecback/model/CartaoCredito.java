package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartaoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCartao;

    private String nomeTitular;

    private String validade;

    private Integer cvv;

    private Double limite;

    private Double faturaAtual;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private br.com.fujideia.iesp.tecback.model.entity.Usuario usuario;
}
