package br.com.fujideia.iesp.tecback.repository;


import br.com.fujideia.iesp.tecback.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme,Integer> {

    public List<Filme> findFilmeByTitulo(String titulo);
    public List<Filme> findFilmeByTituloOrderByTituloAsc(String titulo);
    public List<Filme> findFilmeByTituloAndSinopse(String titulo, String sinopse);
    public List<Filme> findFilmeByTituloLike(String titulo);

    @Query("select f from Filme f where f.genero.titulo=:titulo")
    public List<Filme> getFilmesByGenero(@Param("titulo") String titulo);
}
