package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Forma_Pagamento;
import br.com.fujideia.iesp.tecback.model.Serie;
import br.com.fujideia.iesp.tecback.repository.FormaPagamentoRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class FormaPagamentoService {
    @Autowired
    private FormaPagamentoRepository repository;

    public Forma_Pagamento salvar(Forma_Pagamento forma_pagamento){
        forma_pagamento = this.repository.save(forma_pagamento);
        return forma_pagamento;
    }

    public List<Forma_Pagamento> listar(){
        return repository.findAll();
    }



    public Forma_Pagamento consultarPorId(int id){
        return this.repository.findById(id).orElseThrow(NotFoundException::new);
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
            forma_pagamento = repository.save(forma_pagamento);
        } else {
            throw new NotFoundException();
        }
        return forma_pagamento;

    }
}
