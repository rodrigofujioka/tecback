package br.uniesp.si.techback.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class EntidadeBase {
    private String nome;
    private int ano;
}
