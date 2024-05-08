package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Cartao;
import br.com.fujideia.iesp.tecback.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository {
    Cartao findByEmail(String email);
}
