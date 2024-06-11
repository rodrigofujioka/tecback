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

        String email = usuario.getEmail();

        Usuario novoUsuario = new Usuario();

        return usuarioRepository.save(novoUsuario);
    }

}
