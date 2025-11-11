package br.uniesp.si.techback.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * Implementação do validador para a anotação @TitulosBloqueadosFilme.
 * Este validador verifica se o texto contém alguma palavra da lista de palavras bloqueadas.
 * A verificação é case-insensitive.
 * 
 * Palavras bloqueadas atualmente:
 * - sexo, drogas, violência, pornô, xxx, nazista, racista
 * 
 * Para adicionar mais palavras, basta incluí-las na lista PALAVRAS_BLOQUEADAS.
 */

public class TitulosBloqueadosFilmeValidator implements ConstraintValidator<TitulosBloqueadosFilme, String> {

    // Lista de palavras que não são permitidas nos títulos de filmes
    // Esta lista pode ser facilmente estendida conforme necessário
    private static final List<String> PALAVRAS_BLOQUEADAS = Arrays.asList(
        "sexo", "drogas", "violência", "pornô", "xxx", "nazista", "racista"
    );

    /**
     * Método principal de validação.
     * 
     * @param titulo O valor do campo que está sendo validado
     * @param context Contexto no qual a validação está sendo executada
     * @return true se o título for válido (não contém palavras bloqueadas), false caso contrário
     */
    @Override
    public boolean isValid(String titulo, ConstraintValidatorContext context) {
        // Se o título for nulo ou vazio, consideramos válido
        // A validação de @NotBlank deve ser feita separadamente
        if (titulo == null || titulo.isEmpty()) {
            return true;
        }

        // Converte o título para minúsculas para fazer uma comparação case-insensitive
        String tituloLowerCase = titulo.toLowerCase();
        
        // Verifica se NENHUMA das palavras bloqueadas está contida no título
        return PALAVRAS_BLOQUEADAS.stream()
                .noneMatch(palavra -> tituloLowerCase.contains(palavra.toLowerCase()));
    }
}
