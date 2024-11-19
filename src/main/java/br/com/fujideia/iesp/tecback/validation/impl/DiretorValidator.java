package br.com.fujideia.iesp.tecback.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DiretorValidator implements ConstraintValidator<ValidDiretor, String> {

    @Override
    public boolean isValid(String nomeDiretor, ConstraintValidatorContext context) {
        if (nomeDiretor == null || nomeDiretor.isEmpty()) {
            return true;
        }
        return DiretorBase.isDiretorValido(nomeDiretor);
    }
}
