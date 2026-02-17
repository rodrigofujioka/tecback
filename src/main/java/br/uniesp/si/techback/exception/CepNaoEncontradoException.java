package br.uniesp.si.techback.exception;

import lombok.Getter;

@Getter
public class CepNaoEncontradoException extends RuntimeException {
    private final String cep;
    
    public CepNaoEncontradoException(String cep) {
        super(String.format("CEP não encontrado: %s", cep));
        this.cep = cep;
    }
}
