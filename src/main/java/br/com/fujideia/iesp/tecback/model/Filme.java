package br.com.fujideia.iesp.tecback.model;

import br.com.fujideia.iesp.tecback.validator.IdadeRange;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "o nome do filme não pode estar vazio")
    @Size(min = 2, max = 40, message = "o nome deve conter entre 2 e 40 caracteres")
    private String titulo;

    @NotEmpty(message = "a descrição do filme não pode estar vazio")
    @Size(min = 2, max = 120, message = "a descrição deve conter até 40 caracteres")
    private String descricao;

    @IdadeRange(min = 7, max = 23)
    private Integer idade;

    private Integer anoLancamento;
}