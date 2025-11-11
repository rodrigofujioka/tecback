package br.uniesp.si.techback.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

/**
 * Anotação personalizada para validar se um título de filme contém palavras bloqueadas.
 * Esta anotação pode ser usada em campos de String para garantir que não contenham
 * termos considerados inadequados.
 * 
 * Exemplo de uso:
 * @TitulosBloqueadosFilme(message = "O título contém palavras não permitidas")
 * private String titulo;
 */

@Documented
@Constraint(validatedBy = TitulosBloqueadosFilmeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface TitulosBloqueadosFilme {
    String message() default "O título contém palavras não permitidas";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
