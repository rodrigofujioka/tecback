package br.uniesp.si.techback.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class GeneroValidator implements ConstraintValidator<Genero, String> {

    private static final List<String> GENEROS_VALIDOS = Arrays.asList(
        "Ação",
        "Aventura",
        "Comédia",
        "Drama",
        "Terror",
        "Ficção Científica",
        "Romance",
        "Documentário",
        "Animação",
        "Musical",
        "Suspense",
        "Fantasia",
        "Thriller",
        "Crime",
        "Biografia",
        "Guerra",
        "História",
        "Faroeste",
        "Família",
        "Esporte"
    );

    @Override
    public boolean isValid(String genero, ConstraintValidatorContext context) {
        if (genero == null || genero.isBlank()) {
            return true;
        }
        
        return GENEROS_VALIDOS.contains(genero.trim());
    }
}
