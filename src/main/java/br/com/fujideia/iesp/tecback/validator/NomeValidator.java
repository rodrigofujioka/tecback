package br.com.fujideia.iesp.tecback.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class NomeValidator implements ConstraintValidator<NomeValidation, String> {


    private String message;

    @Override
    public void initialize(NomeValidation constraintAnnotation) {
        message = constraintAnnotation.message();
    }


    @Override
    public boolean isValid(String titulo, ConstraintValidatorContext constraintValidatorContext) {
        if(titulo.contains("Fujioka")){
            return true;
        }
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(message + titulo)//
                .addConstraintViolation();
        return false;
    }
}
