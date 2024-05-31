package br.com.fujideia.iesp.tecback.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = IdadeRangeValidator.class)
public @interface IdadeRange {

    String message()
            default "A idade deve estar entre {min} e {max}.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};

    int min() default 0;
    int max() default Integer.MAX_VALUE;
}
