package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Plano;
import br.com.fujideia.iesp.tecback.model.Serie;
import br.com.fujideia.iesp.tecback.repository.PlanoRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PlanoService {
    @Autowired
    private PlanoRepository repository;

    public Plano salvar(Plano plano){
        plano = this.repository.save(plano);
        return plano;
    }

    public List<Plano> listar(){
        return repository.findAll();
    }



    public Plano consultarPorId(int id){
        return this.repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Boolean excluir(int id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){

            return false;}
        return true;
    }

    public Plano alterar(Plano plano) {
        if (Objects.isNull(plano.getId())) {
            plano = repository.save(plano);
        } else {
            throw new NotFoundException();
        }
        return plano;

    }
}
