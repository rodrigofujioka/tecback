package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

    List<Filme> findByTitulo(String titulo);
    List<Filme> findByTituloOrderByTituloAsc(String titulo);

    @Query("select f from Filme f where f.titulo=:titulo")
    List<Filme> buscarFilmePorTitulo(@Param("titulo") String titulo);

    @Query("select f from Filme f " +
            "where f.titulo=:titulo " +
            "order by f.titulo asc ")
    List<Filme>
    buscarFilmePorTituloOrdenado(@Param("titulo") String titulo);
}
