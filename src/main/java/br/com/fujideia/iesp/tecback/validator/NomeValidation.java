package br.com.fujideia.iesp.tecback.validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;




@Target( { ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NomeValidator.class)
public @interface NomeValidation {
    String message() default "O Nome {} não é aceito ";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
