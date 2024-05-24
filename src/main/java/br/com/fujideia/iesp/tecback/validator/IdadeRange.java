package br.com.fujideia.iesp.tecback.validator;

import jakarta.validation.Constraint;

import javax.xml.transform.sax.SAXResult;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = IdadeRangeValidator.class)

public @interface IdadeRange {

    String message()
            default "A idade deve estar entre {main} e {max}.";
    class<?>[] groups() default{};
    class <? extends Payload>[] payload() default{};

    int min() default 0;
    int max() default Integer.MAX_VALUE;
}
