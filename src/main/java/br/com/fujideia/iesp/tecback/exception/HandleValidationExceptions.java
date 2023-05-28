package br.com.fujideia.iesp.tecback.exception;
import br.com.fujideia.iesp.tecback.dtos.ErrorDTO;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@Order
@ControllerAdvice
public class HandleValidationExceptions {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleException(Exception e) {

        ErrorDTO erroCapturado =
                ErrorDTO.builder() //
                        .error(HttpStatus.BAD_REQUEST.getReasonPhrase()) //
                        .detalhes(e.getMessage())
                        .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroCapturado);
    }
}
