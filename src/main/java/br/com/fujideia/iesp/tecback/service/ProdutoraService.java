package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Produtora;
import br.com.fujideia.iesp.tecback.model.Serie;
import br.com.fujideia.iesp.tecback.repository.ProdutoraRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProdutoraService {
    @Autowired
    private ProdutoraRepository repository;

    public Produtora salvar(Produtora produtora){
        produtora = this.repository.save(produtora);
        return produtora;
    }

    public List<Produtora> listar(){
        return repository.findAll();
    }



    public Produtora consultarPorId(int id){
        return this.repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Boolean excluir(int id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){

            return false;}
        return true;
    }

    public Produtora alterar(Produtora produtora) {
        if (Objects.isNull(produtora.getId())) {
            produtora = repository.save(produtora);
        } else {
            throw new NotFoundException();
        }
        return produtora;

    }
}
