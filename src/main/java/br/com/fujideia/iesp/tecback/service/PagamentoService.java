package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Pagamento;

import br.com.fujideia.iesp.tecback.repository.GeneroRepository;
import br.com.fujideia.iesp.tecback.repository.PagamentoRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository repository;

    public Pagamento salvar(Pagamento pagamento){

        pagamento = this.repository.save(pagamento);
        return pagamento;
    }

    public List<Pagamento> listar(){
        return repository.findAll();
    }



    public Pagamento consultarPorId(int id){
        return this.repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Boolean excluir(int id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){

            return false;}
        return true;
    }

    public Pagamento alterar(Pagamento pagamento) {
        if (Objects.isNull(pagamento.getId())) {
            pagamento = repository.save(pagamento);
        } else {
            throw new NotFoundException();
        }
        return pagamento;

    }
}
