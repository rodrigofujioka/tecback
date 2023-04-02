package br.com.fujideia.iesp.tecback.service;


import br.com.fujideia.iesp.tecback.model.Diretor;
import br.com.fujideia.iesp.tecback.repository.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class DiretorService {
    @Autowired
    private DiretorRepository repository;

    public Diretor salvar(Diretor diretor){
        diretor = this.repository.save(diretor);
        return diretor;
    }

    public List<Diretor> listar(){
        return this.repository.findAll();
    }


    public Diretor consultarPorId(int id){
        return this.repository.findById(id).orElseThrow();
    }

    public Boolean excluir(int id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){

            return false;}
        return true;
    }

    public Diretor alterar(Diretor diretor){
        if(Objects.isNull(diretor.getId())){
            throw new RuntimeException("ID não preenchido");
        }
        return this.repository.save(diretor);
    }
}
