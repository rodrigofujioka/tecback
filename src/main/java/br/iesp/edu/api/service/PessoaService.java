package br.iesp.edu.api.service;


import br.iesp.edu.api.entity.Pessoa;
import br.iesp.edu.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa salvar(Pessoa pessoa){
        return repository.save(pessoa);
    }

    public Pessoa atualizar(Pessoa pessoa) throws Exception {
        if(pessoa.getId()==null){
            throw new Exception("ID não encontrado");
        }
        return repository.save(pessoa);
    }

    public void deletar(int id){
        repository.deleteById(id);
    }

    public List<Pessoa> listar(){
        return repository.findAll();
    }




}
