package br.com.fujideia.iesp.tecback.service;


import br.com.fujideia.iesp.tecback.model.Usuario;
import br.com.fujideia.iesp.tecback.model.dto.UsuarioDTO;
import br.com.fujideia.iesp.tecback.model.dto.UsuarioNomeEmailDTO;
import br.com.fujideia.iesp.tecback.repository.UsuarioRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository repository;

     ModelMapper mapper = new ModelMapper();

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO){
        Usuario usuario = mapper.map(usuarioDTO, Usuario.class);
        usuarioDTO = mapper.map(repository.save(usuario), UsuarioDTO.class);
        return usuarioDTO;
    }

    public Usuario alterar(Usuario usuario){
        if(Objects.nonNull(usuario.getId())){
            usuario = repository.save(usuario);
        }else{
            throw new NotFoundException();
        }
        return usuario;
    }

    public List<UsuarioNomeEmailDTO> listar(){
        List<UsuarioNomeEmailDTO>  listaDTO   =  new ArrayList<>();

        for(Usuario usuario : repository.findAll()){
            listaDTO.add(
                    UsuarioNomeEmailDTO.builder()
                    .nome(usuario.getNome())
                    .email(usuario.getEmail())
                    .build()
            );
        }


        return listaDTO;
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
