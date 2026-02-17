package br.uniesp.si.techback.exception;

// Importações necessárias para o tratamento de exceções
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Classe GlobalExceptionHandler - Responsável por tratar exceções de forma global na aplicação.
 * 
 * @ControllerAdvice - Anotação que permite tratar exceções em toda a aplicação de forma centralizada.
 * Todas as exceções lançadas pelos controladores serão capturadas aqui.
 */

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(CepInvalidoException.class)
    public ResponseEntity<Object> handleCepInvalido(CepInvalidoException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "CEP inválido");
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).replace("uri=", ""));

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CepNaoEncontradoException.class)
    public ResponseEntity<Object> handleCepNaoEncontrado(CepNaoEncontradoException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "CEP não encontrado");
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).replace("uri=", ""));

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    
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

        // Obtém a primeira mensagem de erro para o campo 'message'
        String primeiraMensagem = !errors.isEmpty() ? 
            errors.values().iterator().next() : "Erro de validação nos dados fornecidos";

        // Cria um objeto ErrorDetails com os dados do erro
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),        // Timestamp do erro
                primeiraMensagem,          // Primeira mensagem de erro
                request.getDescription(false), // Descrição da requisição
                errors                     // Mapa de erros de validação
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
