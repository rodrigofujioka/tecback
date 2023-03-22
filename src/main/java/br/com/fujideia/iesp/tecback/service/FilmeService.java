package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.repository.FilmeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
