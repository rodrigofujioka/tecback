package br.com.fujideia.iesp.tecback.service;


import br.com.fujideia.iesp.tecback.FilmesListaDTO;
import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.repository.FilmeRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class FilmeService {
    @Autowired
    private FilmeRepository repository;

    public Filme salvar(Filme filme){
        filme = repository.save(filme);
        return filme;
    }

    public Filme alterar(Filme filme){
        if(Objects.nonNull(filme.getId())){
            filme = repository.save(filme);
        }else{
            throw new NotFoundException();
        }
        return filme;
    }

    public List<Filme> listar(){
        return repository.findAll();
    }

    public Boolean excluir(Integer id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){
            log.info("Erro ao realizar Exclusão : {}", e);
            return false;

        }
        return true;
    }

    public Filme consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public List<Filme> listarFilmePorGenero(String nomeGenero){
        return repository.listarFilmePorGenero(nomeGenero);
    }

    public List<Filme> listarFilmePorAno(String titulo, Integer ano){
        return repository.listarFilmePorAno(titulo, ano);
    }

    public List<FilmesListaDTO> listarFilmeNomeGenero(){
        List<Filme> listaFilme = repository.findAll();
        List<FilmesListaDTO> listaDTO = new ArrayList<>();
        for (Filme f : listaFilme) {
            listaDTO.add(FilmesListaDTO
                    .builder()
                    .nome(f.getTitulo())
                    .nomeGenero(f.getGenero().getNome())
                    .build()
            );
        }return listaDTO;
    }

}
