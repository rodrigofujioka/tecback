package br.com.fujideia.iesp.tecback.service;


import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.model.Serie;
import br.com.fujideia.iesp.tecback.repository.FilmeRepository;
import br.com.fujideia.iesp.tecback.repository.SerieRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SerieService {
    @Autowired
    private SerieRepository repository;

    public Serie salvar(Serie serie){
        serie = this.repository.save(serie);
        return serie;
    }

    public List<Serie> listar(){
        return repository.findAll();
    }



    public Serie consultarPorId(int id){
        return this.repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Boolean excluir(int id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){

            return false;}
        return true;
    }

    public Serie alterar(Serie serie) {
        if (Objects.isNull(serie.getId())) {
            serie = repository.save(serie);
        } else {
            throw new NotFoundException();
        }
        return serie;

    }
}
