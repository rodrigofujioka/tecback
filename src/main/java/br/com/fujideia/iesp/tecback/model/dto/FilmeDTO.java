package br.com.fujideia.iesp.tecback.model.dto;

import java.util.List;
import java.util.Optional;

import br.com.fujideia.iesp.tecback.model.Ator;
import br.com.fujideia.iesp.tecback.model.Diretor;
import br.com.fujideia.iesp.tecback.model.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmeDTO {
    private Long id;
    private String titulo;
    private int anoLancamento;
    private DiretorDTO diretor;
    private List<AtorDTO> atores;
    private List<GeneroDTO> generos;

}