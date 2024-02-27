package br.com.fujideia.iesp.tecback.model.dto;

import br.com.fujideia.iesp.tecback.model.Genero;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilmeDTO {

    private Integer id;
    @NotEmpty
    private String titulo;
    private String sinopse;
    private Integer ano;
    private Genero genero;
}
