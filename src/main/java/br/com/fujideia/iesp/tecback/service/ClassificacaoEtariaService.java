package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Classificacao_Etaria;
import br.com.fujideia.iesp.tecback.repository.ClassificacaoEtariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClassificacaoEtariaService {
    @Autowired
    private ClassificacaoEtariaRepository repository;

    public Classificacao_Etaria salvar(Classificacao_Etaria classificacao_etaria){
        classificacao_etaria = this.repository.save(classificacao_etaria);
        return classificacao_etaria;
    }

    public List<Classificacao_Etaria> listar(){
        return this.repository.findAll();
    }

    public Classificacao_Etaria consultarPorId(int id){
        return this.repository.findById(id).orElseThrow();
    }

    public Boolean excluir(int id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){

            return false;}
        return true;
    }

    public Classificacao_Etaria alterar(Classificacao_Etaria classificacao_etaria){
        if(Objects.isNull(classificacao_etaria.getId())){
            throw new RuntimeException("ID não preenchido");
        }
        return this.repository.save(classificacao_etaria);
    }


}
