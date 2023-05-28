package br.com.fujideia.iesp.tecback.dtos;


import br.com.fujideia.iesp.tecback.model.Cliente;
import br.com.fujideia.iesp.tecback.model.Forma_Pagamento;
import br.com.fujideia.iesp.tecback.model.Plano;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CadastroDto {

    private Forma_Pagamento forma_pagamento;
    private Cliente cliente;
    private String senha;
    private String confirma_senha;



}
