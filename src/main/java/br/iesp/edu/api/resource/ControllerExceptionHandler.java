package br.iesp.edu.api.resource;


import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {


    private static final String ERROR_OUT_OF_RANGE = "value out of range of type ";
    private static final String ERROR_PARSE_EXCEPTION = "error Cannot deserialize value of type, this value is not valid from type ";

    @ExceptionHandler({InvalidFormatException.class})
    public ResponseEntity<ErrorResponseModel> badRequestException(InvalidFormatException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponseModel( ex.getPath().get(0).getFieldName(),  ex.getValue().toString(), getMessage(ex.getMessage(), ex.getTargetType().getSimpleName())),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JsonMappingException.class)
    public ResponseEntity<ErrorResponseModel> badRequestException(JsonMappingException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponseModel( ex.getPath().get(0).getFieldName(),  ex.getPathReference(), getMessage(ex.getMessage(),"")),
                HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponseModel> badRequestException(NullPointerException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponseModel( "Erro INesperado",  "Erro", getMessage(ex.getMessage(),"")),
                HttpStatus.BAD_REQUEST);
    }


    private String getMessage(String errorMessage, String targetType){
        if(errorMessage.contains("out of range of ")){
            errorMessage = ERROR_OUT_OF_RANGE.concat(" : " + targetType);
        }
        if(errorMessage.contains(" not a valid")){
            errorMessage = ERROR_PARSE_EXCEPTION.concat(" : " + targetType);
        }
        return  errorMessage;
    }
}