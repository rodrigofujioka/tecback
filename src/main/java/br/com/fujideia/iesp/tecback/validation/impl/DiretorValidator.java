package br.com.fujideia.iesp.tecback.validation.impl;

import br.com.fujideia.iesp.tecback.validation.DiretorBase;
import br.com.fujideia.iesp.tecback.validation.ValidDiretor;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DiretorValidator implements ConstraintValidator<ValidDiretor, String> {

    @Override
    public boolean isValid(String nomeDiretor, ConstraintValidatorContext context) {
        if (nomeDiretor == null || nomeDiretor.isEmpty()) {
            return true;
        }
        boolean isValid = DiretorBase.isDiretorValido(nomeDiretor);
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    String.format("O nome do diretor '%s' informado não é válido.", nomeDiretor)
            ).addConstraintViolation();
        }
        return isValid;
    }
}
