package br.uniesp.si.techback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Filme {



    private Long id;
    private String titulo;
    private String genero;
    private int anoLancamento;
}
