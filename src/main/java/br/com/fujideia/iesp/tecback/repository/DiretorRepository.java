package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Diretor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Long> {
    @Query("SELECT d FROM Diretor WHERE d.nome LIKE %nome%");
    List<Diretor> procurarPorNome(@Param("nome") String nome);
}
