package br.com.fujideia.iesp.tecback.model.dto;

import java.util.List;

import br.com.fujideia.iesp.tecback.model.Filme;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiretorDTO {
    private Long id;
    private String nome;
}
