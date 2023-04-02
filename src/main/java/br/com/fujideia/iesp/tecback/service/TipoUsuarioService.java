package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Serie;
import br.com.fujideia.iesp.tecback.model.Tipo_Usuario;
import br.com.fujideia.iesp.tecback.repository.TipoUsuarioRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TipoUsuarioService {
    @Autowired
    private TipoUsuarioRepository repository;

    public Tipo_Usuario salvar(Tipo_Usuario tipo_usuario){
        tipo_usuario = this.repository.save(tipo_usuario);
        return tipo_usuario;
    }

    public List<Tipo_Usuario> listar(){
        return repository.findAll();
    }



    public Tipo_Usuario consultarPorId(int id){
        return this.repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Boolean excluir(int id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){

            return false;}
        return true;
    }

    public Tipo_Usuario alterar(Tipo_Usuario tipo_usuario) {
        if (Objects.isNull(tipo_usuario.getId())) {
            tipo_usuario = repository.save(tipo_usuario);
        } else {
            throw new NotFoundException();
        }
        return tipo_usuario;

    }
}


