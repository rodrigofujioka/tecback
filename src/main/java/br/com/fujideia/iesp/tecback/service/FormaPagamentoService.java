package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.dtos.CadastroDto;

import br.com.fujideia.iesp.tecback.model.Forma_Pagamento;
import br.com.fujideia.iesp.tecback.repository.FormaPagamentoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class FormaPagamentoService {
    @Autowired
    private FormaPagamentoRepository repository;

    ModelMapper mapper = new ModelMapper();

    @Transactional
    public CadastroDto salvar(CadastroDto cadastroDto, Integer id_cliente){
        Forma_Pagamento forma_pagamento = mapper.map(cadastroDto.getForma_pagamento(), Forma_Pagamento.class);
        forma_pagamento.setId_cliente(id_cliente);
        cadastroDto = mapper.map(repository.save(forma_pagamento), CadastroDto.class);
        return cadastroDto;
    }

    public List<Forma_Pagamento> listar(){
        return repository.findAll();
    }



    public Forma_Pagamento consultarPorId(int id){
        return this.repository.findById(id).orElseThrow();
    }

    public Boolean excluir(int id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){

            return false;}
        return true;
    }

    public Forma_Pagamento alterar(Forma_Pagamento forma_pagamento) {
        if (Objects.isNull(forma_pagamento.getId())) {
            throw new RuntimeException("ID não preenchido");
        }
        return this.repository.save(forma_pagamento);
    }
}
