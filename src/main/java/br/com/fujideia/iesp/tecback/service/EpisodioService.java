package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Episodio;
import br.com.fujideia.iesp.tecback.repository.EpisodioRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class EpisodioService {

    @Autowired
    private EpisodioRepository repository;

    public Episodio salvar(Episodio episodio){
        return repository.save(episodio);
    }

    public Episodio alterar(Episodio episodio){
        if(Objects.nonNull(episodio.getId())){
            return repository.save(episodio);
        } else {
            throw new NotFoundException();
        }
    }

    public List<Episodio> listar(){
        return repository.findAll();
    }

    public Boolean excluir(Integer id){
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("Erro ao excluir episódio: {}", e.getMessage());
            return false;
        }
    }

    public Episodio consultarPorId(Integer id){
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }
}
