package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.PrimitiveIterator;

@Data
@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "o número não pode estar vazio")
    @Size(min = 16, max = 16, message = "o número deve conter 16 caracteres")
    @Pattern(regexp = "\\d{16}", message = "O número deve conter apenas dígitos")
    private String numero;

    @NotEmpty(message = "o Código de Segurança não pode estar vazio")
    @Size(min = 3, max = 3, message = "o número deve conter 3 caracteres")
    @Pattern(regexp = "\\d{3}", message = "O número deve conter apenas dígitos")
    private String codigoSeguranca;

    @NotEmpty(message = "o nome não pode estar vazio")
    @Size(min = 2, max = 35, message = "o nome deve conter entre 2 e 35 caracteres")
    private String nomeTitular;

    @NotEmpty(message = "a data de validade não pode estar vazio")
    private String dataValidade;
}
