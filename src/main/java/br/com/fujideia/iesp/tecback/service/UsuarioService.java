package br.com.fujideia.iesp.tecback.service;


import br.com.fujideia.iesp.tecback.model.Usuario;
import br.com.fujideia.iesp.tecback.repository.UsuarioRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario salvar(Usuario usuario){
        usuario = this.repository.save(usuario);
        return usuario;
    }

    public List<Usuario> listar(){
        return repository.findAll();
    }



    public Usuario consultarPorId(int id){
        return this.repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Boolean excluir(int id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){

            return false;}
        return true;
    }

    public Usuario alterar(Usuario usuario) {
        if (Objects.isNull(usuario.getId())) {
            usuario = repository.save(usuario);
        } else {
            throw new NotFoundException();
        }
        return usuario;

    }

}
