package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.model.Genero;
import br.com.fujideia.iesp.tecback.repository.FilmeRepository;
import br.com.fujideia.iesp.tecback.repository.GeneroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GeneroService {
    private GeneroRepository repository;

    public Genero salvar(Genero genero){
        return repository.save(genero);
    }

    public List<Genero> listarTodos(){
        return repository.findAll();
    }

    public Genero atualizar(Genero genero){
        if(genero.getId()==null){
            throw new RuntimeException("Genero sem ID");
        }
        return repository.save(genero);
    }

    public Genero buscarPorId(Integer id){
        return repository.findById(id).get();
    }

    public void excluir(Integer id){
        repository.deleteById(id);
    }

}
