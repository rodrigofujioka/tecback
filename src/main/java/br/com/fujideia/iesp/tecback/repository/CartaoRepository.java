package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Integer> {
    Cartao findFirstByNumero(String numero);
}
