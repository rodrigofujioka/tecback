package br.com.fujideia.iesp.tecback.model.dto;


import br.com.fujideia.iesp.tecback.validator.IdadeRange;
import lombok.Data;

@Data
public class ValidatorDTO {


    private String nome;
    @IdadeRange(min = 10 , max = 50)
    private Integer idade;

}
