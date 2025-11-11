package br.uniesp.si.techback.exception;

import lombok.Getter;

@Getter
public class CepInvalidoException extends RuntimeException {
    private final String cep;
    
    public CepInvalidoException(String cep) {
        super(String.format("CEP inválido: %s. O CEP deve conter 8 dígitos.", cep));
        this.cep = cep;
    }
}
