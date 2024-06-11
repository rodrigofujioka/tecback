package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Cartao;
import br.com.fujideia.iesp.tecback.repository.CartaoRepository;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CartaoService {
    private CartaoRepository repository;

    public Cartao salvar(Cartao cartao){
        return repository.save(cartao);
    }

    public List<Cartao> listarTodos(){
        return repository.findAll();
    }

    public Cartao atualizar(Cartao cartao){
        if (cartao.getId()==null){
            throw new RuntimeException("Cartão sem ID");
        }
        return repository.save(cartao);
    }

    public Cartao buscarPorNumero(Integer numero){
        return repository.findById(numero).get();
    }

    public void excluirPorNumero(Integer id){
        repository.deleteById(id);
    }
}
