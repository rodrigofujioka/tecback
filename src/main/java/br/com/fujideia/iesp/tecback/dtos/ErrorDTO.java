package br.com.fujideia.iesp.tecback.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class ErrorDTO {
    private String error;

    private String detalhes;
}
