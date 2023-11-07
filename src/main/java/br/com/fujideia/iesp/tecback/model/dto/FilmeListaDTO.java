package br.com.fujideia.iesp.tecback.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FilmeListaDTO {
    private String nome;
    private String nomeGenero;
}
