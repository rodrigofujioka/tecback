package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

    @Query("SELECT g FROM Genero g WHERE g.nome LIKE %nome% ")
    List<Genero> buscarPorNome(@Param("nome") String nome);

}
