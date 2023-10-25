package br.com.fujideia.iesp.tecback;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class FilmesListaDTO {

    private String nome;
    private String nomeGenero;


}
