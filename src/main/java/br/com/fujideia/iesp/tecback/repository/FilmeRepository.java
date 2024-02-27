package br.com.fujideia.iesp.tecback.repository;


import br.com.fujideia.iesp.tecback.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme,Integer> {

    List<Filme> findFilmeByTitulo(String titulo);

    @Query("select f From Filme f where f.titulo =:titulo")
    List<Filme> listarFilmesPorTitulo(String titulo);

    @Query("select filme from Filme filme where filme.genero.nome=:nomeGenero")
    List<Filme> listarFilmesPorGenero(String nomeGenero);

    @Query("select filme from Filme filme " +
            " where filme.titulo=:titulo and filme.ano=:ano")
    List<Filme> listarFilmePorTituloAno(String titulo, Integer ano);
    List<Filme> findFilmeByTituloAndAno(String titulo, Integer ano);

}
