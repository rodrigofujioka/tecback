package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Genero;
import br.com.fujideia.iesp.tecback.model.Serie;
import br.com.fujideia.iesp.tecback.repository.GeneroRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository repository;

    public Genero salvar(Genero genero){
        genero = this.repository.save(genero);
        return genero;
    }

    public List<Genero> listar(){
        return repository.findAll();
    }



    public Genero consultarPorId(int id){
        return this.repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Boolean excluir(int id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){

            return false;}
        return true;
    }

    public Genero alterar(Genero genero) {
        if (Objects.isNull(genero.getId())) {
            genero = repository.save(genero);
        } else {
            throw new NotFoundException();
        }
        return genero;

    }
}
