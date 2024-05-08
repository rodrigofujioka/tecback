package br.com.fujideia.iesp.tecback.model;

import lombok.Data;

import java.util.Date;
import java.util.PrimitiveIterator;

@Data
public class Cartao {
    private String niomero;
    private String codigoSeguranca;
    private String nomeTitular;
    private Date dataValidade;
}
