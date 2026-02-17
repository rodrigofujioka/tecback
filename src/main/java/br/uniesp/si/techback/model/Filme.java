package br.uniesp.si.techback.model;

import br.uniesp.si.techback.validation.TitulosBloqueadosFilme;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    @Column(nullable = false, length = 100)
    @TitulosBloqueadosFilme
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String sinopse;

    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    @Column(length = 50)
    private String genero;

    @Column(name = "duracao_minutos")
    private Integer duracaoMinutos;

    @Column(name = "classificacao_indicativa", length = 10)
    private String classificacaoIndicativa;
}
