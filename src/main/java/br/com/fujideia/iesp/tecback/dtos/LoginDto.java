package br.com.fujideia.iesp.tecback.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private String email;
    private  String senha;
}
