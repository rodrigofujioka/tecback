package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Usuario;
import br.com.fujideia.iesp.tecback.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrarUsuario(Usuario usuario){
        //pega o usuario a ser trocado pelo email
        String email = usuario.getEmail();

        //Cria uma nova instancia de usuario com os novos dados
        Usuario novoUsuario = new Usuario();

        //salva o novo usuario no BD
        return usuarioRepository.save(novoUsuario);
    }

}
