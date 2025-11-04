package br.uniesp.si.techback.exception;

// Importações necessárias para o tratamento de exceções
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe GlobalExceptionHandler - Responsável por tratar exceções de forma global na aplicação.
 * 
 * @ControllerAdvice - Anotação que permite tratar exceções em toda a aplicação de forma centralizada.
 * Todas as exceções lançadas pelos controladores serão capturadas aqui.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Trata exceções de validação lançadas quando os dados de entrada são inválidos.
     * 
     * @param ex      A exceção MethodArgumentNotValidException contendo os erros de validação
     * @param request O objeto WebRequest contendo informações sobre a requisição
     * @return ResponseEntity contendo os detalhes do erro e status HTTP 400 (BAD_REQUEST)
     * 
     * @ExceptionHandler - Especifica que este método trata exceções do tipo MethodArgumentNotValidException
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handleValidationExceptions(
            MethodArgumentNotValidException ex, WebRequest request) {
        
        // Mapa para armazenar os erros de validação (campo -> mensagem de erro)
        Map<String, String> errors = new HashMap<>();
        
        // Itera sobre todos os erros de validação encontrados
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            // Obtém o nome do campo que falhou na validação
            String fieldName = ((FieldError) error).getField();
            // Obtém a mensagem de erro definida nas anotações de validação
            String errorMessage = error.getDefaultMessage();
            // Adiciona o erro ao mapa
            errors.put(fieldName, errorMessage);
        });

        // Cria um objeto ErrorDetails com os dados do erro
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),        // Timestamp do erro
                "Erro de validação",       // Título do erro
                request.getDescription(false), // Descrição da requisição
                errors                      // Mapa de erros de validação
        );

        // Retorna a resposta com status 400 (BAD_REQUEST) e o corpo contendo os detalhes do erro
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    /**
     * Trata exceções do tipo IllegalArgumentException lançadas na aplicação.
     * 
     * @param ex      A exceção IllegalArgumentException que foi lançada
     * @param request O objeto WebRequest contendo informações sobre a requisição
     * @return ResponseEntity contendo os detalhes do erro e status HTTP 400 (BAD_REQUEST)
     * 
     * @ExceptionHandler - Especifica que este método trata exceções do tipo IllegalArgumentException
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDetails> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        
        // Cria um objeto ErrorDetails com os dados do erro
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),        // Timestamp do erro
                ex.getMessage(),            // Mensagem da exceção
                request.getDescription(false), // Descrição da requisição
                null                        // Sem erros adicionais
        );

        // Retorna a resposta com status 400 (BAD_REQUEST) e o corpo contendo os detalhes do erro
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    // You can add more exception handlers here as needed
}
