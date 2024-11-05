package br.com.fujideia.iesp.tecback.model.entity;

import br.com.fujideia.iesp.tecback.model.CartaoCredito;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartaoCredito> cartoes;

    public void adicionarCartao(CartaoCredito cartao) {
        cartoes.add(cartao);
        cartao.setUsuario(this);
    }

    public void removerCartao(CartaoCredito cartao) {
        cartoes.remove(cartao);
        cartao.setUsuario(null);
    }
}
