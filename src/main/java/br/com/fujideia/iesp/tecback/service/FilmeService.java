package br.com.fujideia.iesp.tecback.service;


import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.model.dto.FilmeDTO;
import br.com.fujideia.iesp.tecback.model.dto.FilmeListaDTO;
import br.com.fujideia.iesp.tecback.repository.FilmeRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class FilmeService {

    ModelMapper mapper = new ModelMapper();

    @Autowired
    private FilmeRepository repository;

    public Filme salvar(Filme filme){
        filme = repository.save(filme);
        return filme;
    }

    public FilmeDTO alterar(Filme filme){

        if(Objects.nonNull(filme.getId())){
            filme = repository.save(filme);
        }else{
            throw new NotFoundException();
        }
        return mapper.map(filme, FilmeDTO.class);
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

    public FilmeDTO consultarPorId(Integer id){

        //recupera o model do banco
        var filme = repository
                .findById(id)
                .orElseThrow(NotFoundException::new);

        //converte em DTP utilizando Model Mapper
        var filmeDTO = mapper.map(filme, FilmeDTO.class);

        return filmeDTO;
    }

    public List<Filme> listarFilmesPorGenero(String nomeGenero){

        return repository.listarFilmesPorGenero(nomeGenero);
    }

    public List<FilmeListaDTO> listaFilmeNomeGenero(){
        var listaFilme = repository.findAll();
        var listaDTO = new ArrayList<FilmeListaDTO>();
        for(Filme filme : listaFilme){
            listaDTO.add(
                    FilmeListaDTO
                            .builder()
                            .nome(filme.getTitulo())
                            .nomeGenero(filme.getGenero().getNome())
                            .build()
            );
        }
        return listaDTO;
    }




}
