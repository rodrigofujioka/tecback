package br.uniesp.si.techback.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

// Indica que essa anotação será exibida na documentação JavaDoc
@Documented
// Define que essa anotação será usada como uma constraint de validação (Bean Validation)
// O validador que será usado é o IespEmailValidator
@Constraint(validatedBy = IespEmailValidator.class)
// Especifica onde essa anotação pode ser aplicada (em atributos de classe e métodos)
@Target({ ElementType.FIELD, ElementType.METHOD })
// Define que essa anotação estará disponível em tempo de execução (necessário para o Bean Validation funcionar)
@Retention(RetentionPolicy.RUNTIME)
// Define a criação de uma anotação personalizada chamada "ApenasIespEmail"
public @interface ApenasIespEmail {

    // Mensagem padrão que será exibida se a validação falhar
    String message() default "O e-mail não é válido pois não contém '@iesp.com.br'";

    // Usado para agrupar validações, geralmente deixado vazio
    Class<?>[] groups() default {};

    // Define payloads adicionais para carregamento de metadados. Raramente usado em projetos comuns
    Class<? extends Payload>[] payload() default {};
}
