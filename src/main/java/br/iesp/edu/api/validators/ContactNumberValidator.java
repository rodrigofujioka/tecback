package br.iesp.edu.api.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class ContactNumberValidator implements
        ConstraintValidator<StringValidatorConstraint, String>{

    @Override
    public void initialize(StringValidatorConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(Objects.nonNull(value)) {
            return true;
        }
        return false;
    }
}