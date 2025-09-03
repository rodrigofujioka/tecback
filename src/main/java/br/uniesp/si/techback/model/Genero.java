package br.uniesp.si.techback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Genero {
    private Long id;
    private String categoria;
    private String faxaEtaria;
}
