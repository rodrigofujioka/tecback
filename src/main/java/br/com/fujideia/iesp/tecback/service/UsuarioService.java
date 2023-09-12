package br.com.fujideia.iesp.tecback.service;


import br.com.fujideia.iesp.tecback.model.Usuario;
import br.com.fujideia.iesp.tecback.repository.UsuarioRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    public Usuario salvar(Usuario usuario){

        return repository.save(usuario);
    }

    public Usuario alterar(Usuario usuario){
        if(Objects.nonNull(usuario.getId())){
            usuario = repository.save(usuario);
        }else{
            throw new NotFoundException();
        }
        return usuario;
    }

    public List<Usuario> listar(){
        return repository.findAll();
    }

    public Boolean excluir(Integer id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){
            log.info("Erro ao realizar Exclusão : {}", e);
            return false;

        }
        return true;
    }

    public Usuario consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }

}
