package br.uniesp.si.techback.exception;
/**
 * Excecao simples para regras de negocio da aplicacao.
 *
 * Exemplo de uso:
 * throw new CustomBeanException("Mensagem amigavel para o aluno");
 */
public class CustomBeanException extends RuntimeException {
    public CustomBeanException(String message) {
        super(message);
    }
}