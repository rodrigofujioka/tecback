package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Cliente;
import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.repository.FilmeRepository;

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
        return this.repository.findById(id).orElseThrow();
    }

    public void excluir(int id){
        this.repository.deleteById(id);
    }

    public Filme alterar(Filme filme){
        if(Objects.isNull(filme.getId())){
            throw new RuntimeException("ID não preenchido");
        }
        return this.repository.save(filme);
    }

    public List<Filme> buscarFilmeLike(String nome){
        return this.repository.buscarFilmePorNomeLike(nome);
    }
}
