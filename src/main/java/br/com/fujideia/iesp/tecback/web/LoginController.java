package br.com.fujideia.iesp.tecback.web;

import br.com.fujideia.iesp.tecback.dtos.CadastroDto;
import br.com.fujideia.iesp.tecback.dtos.LoginDto;
import br.com.fujideia.iesp.tecback.model.Pagamento;
import br.com.fujideia.iesp.tecback.model.Usuario;
import br.com.fujideia.iesp.tecback.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("")
    public ResponseEntity<String> logar(@RequestBody @Validated LoginDto loginDto){
        String mensagemError = "Usuario ou senha errado.";
        List<Usuario> usuarios = usuarioService.listar();
        for(Usuario user : usuarios){
            if(user.getEmail().equals(loginDto.getEmail()) && user.getSenha().equals(loginDto.getSenha())){
                return ResponseEntity.ok(user.getNome_usuario());
            }
        }
        return ResponseEntity.ok(mensagemError);
    }
}
