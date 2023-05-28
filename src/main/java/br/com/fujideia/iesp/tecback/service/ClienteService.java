package br.com.fujideia.iesp.tecback.service;


import br.com.fujideia.iesp.tecback.dtos.CadastroDto;
import br.com.fujideia.iesp.tecback.model.Cliente;
import br.com.fujideia.iesp.tecback.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    ModelMapper mapper = new ModelMapper();

    @Transactional
    public CadastroDto salvar(CadastroDto cadastroDto){
        Cliente cliente = mapper.map(cadastroDto.getCliente(), Cliente.class);
        cadastroDto = mapper.map(repository.save(cliente), CadastroDto.class);
        return cadastroDto;
    }

    public List<Cliente> listar(){
        return this.repository.findAll();
    }


    public Cliente consultarPorId(int id){
        return this.repository.findById(id).orElseThrow();
    }

    public Boolean excluir(int id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){

            return false;}
        return true;
    }

    public Cliente alterar(Cliente cliente){
        if(Objects.isNull(cliente.getId())){
            throw new RuntimeException("ID não preenchido");
        }
        return this.repository.save(cliente);
    }
}
