package br.com.fujideia.iesp.tecback.model;

import lombok.Data;
import java.util.Date;

@Data
public class Cartao {
    private String numero;
    private String codigoSeguranca;
    private String nomeTitular;
    private Date dataValidade;
}
