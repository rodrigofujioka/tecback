package br.uniesp.si.techback.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EntidadeNaoEncontradaException extends RuntimeException {
    
    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
        log.warn("Recurso não encontrado: {}", mensagem);
    }
    
    public EntidadeNaoEncontradaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
        log.warn("Recurso não encontrado: {} - Causa: {}", mensagem, causa.getMessage());
        log.debug("Detalhes do erro:", causa);
    }
}
