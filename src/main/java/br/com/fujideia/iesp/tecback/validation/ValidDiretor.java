package br.com.fujideia.iesp.tecback.validation;

import br.com.fujideia.iesp.tecback.validation.impl.DiretorValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DiretorValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDiretor {
    String message() default "O nome do diretor informado não é válido.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
