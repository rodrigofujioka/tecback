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
public class FilmeService {

    @Autowired //chama o construtor do spring
    private FilmeRepository repository;


    public Filme salvar(Filme filme){
        filme = this.repository.save(filme);
        return filme;
    }

    public List<Filme> listar(){
        return repository.findAll();
    }



    public Filme consultarPorId(int id){
        return this.repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Boolean excluir(int id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){

            return false;}
        return true;
    }

    public Filme alterar(Filme filme) {
        if (Objects.isNull(filme.getId())) {
            filme = repository.save(filme);
        } else {
            throw new NotFoundException();
        }
        return filme;

    }




}
