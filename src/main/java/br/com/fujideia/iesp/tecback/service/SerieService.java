package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Serie;
import br.com.fujideia.iesp.tecback.repository.SerieRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class SerieService {

    @Autowired
    private SerieRepository repository;

    public Serie salvar(Serie serie){
        return repository.save(serie);
    }

    public Serie alterar(Serie serie){
        if(Objects.nonNull(serie.getId())){
            return repository.save(serie);
        } else {
            throw new NotFoundException();
        }
    }

    public List<Serie> listar(){
        return repository.findAll();
    }

    public Boolean excluir(Integer id){
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("Erro ao excluir série: {}", e.getMessage());
            return false;
        }
    }

    public Serie consultarPorId(Integer id){
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }
}
