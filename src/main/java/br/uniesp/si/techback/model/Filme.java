package br.uniesp.si.techback.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Filme {

    private long id;
    private String titulo, genero;
    private int anoLancamento;

}
