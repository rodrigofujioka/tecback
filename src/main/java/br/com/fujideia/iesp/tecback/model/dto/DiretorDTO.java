package br.com.fujideia.iesp.tecback.model.dto;

import br.com.fujideia.iesp.tecback.validation.ValidDiretor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiretorDTO {
    private Long id;

    @ValidDiretor
    private String nome;
}
