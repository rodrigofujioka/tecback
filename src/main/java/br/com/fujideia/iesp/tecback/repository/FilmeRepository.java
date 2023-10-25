package br.com.fujideia.iesp.tecback.repository;


import br.com.fujideia.iesp.tecback.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FilmeRepository extends JpaRepository<Filme,Integer> {

    List<Filme> findFilmeByTitulo(String titulo);
    @Query("select filme from Filme filme where filme.genero=:nomeGenero" + " order by filme.titulo asc")
    List<Filme> listarFilmePorGenero(String nomeGenero);

    @Query("select f from Filme f where f.titulo=:titulo")
    List<Filme> listarFilmePorTitulo(String titulo);

    @Query("select filme from Filme filme where filme.titulo=:titulo and filme.ano=:ano")
    List<Filme> listarFilmePorAno(String titulo, Integer ano);

    List<Filme> findFilmeByTituloAndAno(String titulo, Integer ano);
}
